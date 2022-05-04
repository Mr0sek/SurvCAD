package net.osek.survcad.sidePanes.functions;

import javafx.scene.layout.Pane;
import net.osek.survcad.sidePanes.FunctionBar;
import net.osek.survcad.sidePanes.FunctionButton;
import net.osek.survcad.sidePanes.FunctionManager;
import net.osek.survcad.utils.ToolIDs;

import java.util.ArrayList;

public class Function extends Pane {

    private static ArrayList<ToolIDs> activeFunctions = new ArrayList<>();

    private ToolIDs id;

    private FunctionButton functionButton;

    public Function (ToolIDs id, String name) {

       if(activeFunctions.contains(id)) {
           return;  // this object should be automatically deleted by the java garbage collector
       }

       this.id = id;
       activeFunctions.add(id);


        // todo: get from database, to which function bar this belongs
        FunctionBar functionBar = FunctionManager.getTopLeftFunctionBar();

        functionButton = new FunctionButton(id, name, this);
        functionBar.addButton(functionButton);
    }

    public void show() {
        FunctionManager.getTopLeftFunctionWindow().showFunctionWindow(this);
    }

    public void hide() {
        FunctionManager.getTopLeftFunctionWindow().hideFunctionWindow();
    }
}
