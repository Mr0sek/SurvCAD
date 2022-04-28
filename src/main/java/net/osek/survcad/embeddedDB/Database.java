package net.osek.survcad.embeddedDB;

import java.sql.*;

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

            System.out.println("in connection" + ex);
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
}