package net.osek.survcad.embeddedDB;

import net.osek.survcad.Main;
import net.osek.survcad.utils.StringUtil;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Base64;
import javax.imageio.ImageIO;

public class Database {

    private Connection conn = null;
    private Statement stmt;
    private ResultSet rs = null;

    public Database() {

        try {

            String projectRoot = System.getProperty("user.dir");
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            conn = DriverManager.getConnection(
                    "jdbc:derby:" + projectRoot + "/src/main/java/net/osek/survcad/embeddedDB/internDB/internDB"
            );

            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            conn.commit();

        } catch (SQLException ex) {

            ex.printStackTrace();
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }

    }

    public void close () {

        try {
            DriverManager.getConnection ("jdbc:derby:;shutdown=true");

        } catch (SQLException ex) {
            if (((ex.getErrorCode() != 50000) || !("XJ015".equals(ex.getSQLState())))) {

                System.err.println(ex.getMessage());
            }
        }
    }

    // load image from database by ID
    public String getButtonImagePath(int id) throws SQLException, IOException, NoEntryException {

        rs = stmt.executeQuery("SELECT * FROM \"TOOLS_IMAGES\" WHERE \"TOOL_id\" = " + id );

        // get data from database
        if(!rs.next()) {
            throw new NoEntryException("TOOLS_IMAGES", "TOOL_id", ""+id);
        }

        String imgData = rs.getString("TOOL_img").toString();

        // fix string
        // load image from database
        return StringUtil.fixUrlForCss(System.getProperty("user.dir") + "/" + imgData);
    }
}