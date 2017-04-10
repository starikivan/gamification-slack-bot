package juja.microservices.gamification.slackbot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Vitalii Viazovoi
 */
@Getter
@Setter
@ToString
//@JsonIgnoreProperties({"parcedUuidPattern", "parcedUuidStartMarker",
//        "parcedUuidFinishMarker", "command_EXAMPLE"})
public class ThanksAchievement {
    private String from;
    private String to;
    private String description;

    private String parcedUuidPattern = "@#([a-zA-z0-9\\.\\_\\-]){1,21}#@";
    private String parcedUuidStartMarker = "@#";
    private String parcedUuidFinishMarker = "#@";
    private final String COMMAND_EXAMPLE = "/thanks Thanks to @slack_nick_name for bla bla blabl abl. Blabla bla blabl.";

    public ThanksAchievement(String from, String to, String description) {
        this.from = from;
        this.to = to;
        this.description = description;
    }

    public ThanksAchievement(String fromUserUuid, String text) {
        this.from = fromUserUuid;
        this.to = findUuid(text);
        this.description = text;
    }

    private String findUuid(String text) {
        return text.replaceAll("^.+@#","").replaceAll("#@.+$","");
    }
}