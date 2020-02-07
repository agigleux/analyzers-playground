package java12preview;

public class SwitchJPE325 {

    public void validation(String day) {
        String result = "";

        switch (day) {
        case "M":
        case "W":
        case "F": {
            result = "MWF";
            break;
        }
        case "T":
        case "TH":
        case "S": {
            result = "TTS";
            break;
        }
        }
        ;

        System.out.println("Old Switch Result:");
        System.out.println(result);
    }

    /*
    public void validationJava12(String day) {
        String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if(day.isEmpty())
                    break "Please insert a valid day.";
                else
                    break "Looks like a Sunday.";
            }

        };

        System.out.println(result);
    }
    */
}