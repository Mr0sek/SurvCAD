package net.osek.survcad.utils;

public enum ToolIDs {
    X_CLOSE(10),
    CREATE_PROJECT (1001),

    F_PROJECT (2001),
    F_FILES (2002);

    private int toolID;
    ToolIDs(int toolID) {
        this.toolID = toolID;
    }

    public int getID() { return toolID; }
}
