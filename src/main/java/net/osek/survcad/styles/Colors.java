package net.osek.survcad.styles;

public enum Colors {
    MENU_BAR_BACKGROUND_ACTIVE("#f8f8f9"),
    MENU_BAR_BORDER_ACTIVE("#4c77df"),
    MENU_BAR_BACKGROUND_INACTIVE("#ededeb"),
    MENU_BAR_BACKGROUND_HOVER("b4b5b4"),
    MENU_BAR_TEXT_COLOR_ACTIVE("#1e2018"),
    MENU_BAR_TEXT_COLOR_INACTIVE("#1e2018"),
    MENU_BAR_TEXT_COLOR_HOVER("#1e2018"),

    TOOLBAR_BACKGROUND_COLOR("#f6fafb"),
    TOOLBAR_TEXT_COLOR("#1e2018"),

    BORDER_COLOR("#d4d3d7");

    private String color;

    private Colors (String color) {
        this.color = color;
    }

    public String getColor () {
        return color;
    }
}
