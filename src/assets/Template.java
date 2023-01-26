package assets;

public class Template {
    // colors
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // styles font
    public static final String ANSI_BOLD = "\u001B[1m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";
    public static final String ANSI_ITALIC = "\u001B[3m";
    public static final String ANSI_STRIKETHROUGH = "\u001B[9m";

    // animations



    public static void presentation() {

        System.out.println("=========================================================================");
        System.out.print("|                         ");
        System.out.print(Template.ANSI_BOLD + "Welcome to the workshop" + Template.ANSI_RESET);
        System.out.print("                       |\n");
        System.out.println("=========================================================================");
        System.out.println();

        System.out.println(Template.ANSI_GREEN + "          __--------_");
        System.out.println("         / l    \\~-_ \\");
        System.out.println(",----~~~~--+-----`--~----______");
        System.out.println("@   /~_~\\  | ~      |   /~_~\\~~~-,");
        System.out.println("\\_ ( (_) )  \\_______|  ( (_) )_-~");
        System.out.println("  ~~\\___/~~~~~~~~~~~~~~~\\___/~" + Template.ANSI_RESET);

    }

    public static void bye() {
        System.out.println("==========================================================================");
        System.out.print("|                         ");
        System.out.print(Template.ANSI_BOLD + "Bye" + Template.ANSI_RESET);
        System.out.print("                       |\n");
        System.out.println("=========================================================================");
        System.exit(0);
    }



}
