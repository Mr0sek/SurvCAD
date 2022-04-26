package net.osek.survcad.styles;

public enum Colors {
    MENU_BAR_BACKGROUND_ACTIVE("#f6fafb"),
    MENU_BAR_BACKGROUND_INACTIVE("#08092e"),
    MENU_BAR_BACKGROUND_HOVER("#08092e"),
    MENU_BAR_TEXT_COLOR_ACTIVE("#08092e"),
    MENU_BAR_TEXT_COLOR_INACTIVE("#f6fafb"),
    MENU_BAR_TEXT_COLOR_HOVER("#f6fafb"),

    TOOLBAR_BACKGROUND_COLOR("#f6fafb"),

    BORDER_COLOR("#08091a");

    private String color;

    private Colors (String color) {
        this.color = color;
    }

    public String getColor () {
        return color;
    }
}
