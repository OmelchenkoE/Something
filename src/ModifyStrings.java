import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModifyStrings {
    public void modify(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("END_COMMAND");
        strings.add("INACTIVITY_TIMEOUT");
        strings.add("STOP_COMMAND");
        strings.add("AGENT_RECEIVE_CHAT");
        strings.add("FLAG_CHAT");
        strings.add("UNFLAG_CHAT");
        strings.add("TICKET_ASSIGNED");
        strings.add("TRANSFER_TICKET");
        strings.add("INVITE_AGENT");
        strings.add("AGENT_REJECT_CHAT");
        strings.add("CLOSE_CHAT");
        List<String> newStrings = strings.stream().map(s -> { //peek does not work, because String is immutable
            s = s.toLowerCase();
            int i = s.indexOf("_");
            char c = s.charAt(i + 1);
            char u = s.charAt(0);
            StringBuilder myName = new StringBuilder(s);
            myName.setCharAt(i + 1, Character.toUpperCase(c));
            myName.setCharAt(0, Character.toUpperCase(u));
            s = myName.toString();
            s = s.replace("_", "");
            return "create" + s + "Message";
        })
                .collect(Collectors.toList());
        newStrings.forEach(System.out::println);
    }
}
