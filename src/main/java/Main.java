import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;
import discord4j.core.spec.EmbedCreateSpec;
import discord4j.rest.util.Color;

import java.time.Instant;

public class Main {

    public static  void main(String[]args){

        final String token = "OTUzNjMxMTc4OTI4MzEyMzYx.YjHYPg.nZlNv34Q7zXlLF2dpIE-8zrqn7M";
        final DiscordClient client = DiscordClient.create(token);
        final GatewayDiscordClient gateway = client.login().block();

        EmbedCreateSpec embed = EmbedCreateSpec.builder()
                .color(Color.BLUE)
                .title("Title")
                .url("https://discord4j.com")
                .author("Some Name", "https://discord4j.com", "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/hc_1440x810/public/media/image/2022/03/xokas-2650403.jpg?itok=mi1pySjM")
                .description("Y tu callao Vaca")
                .thumbnail("https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/hc_1440x810/public/media/image/2022/03/xokas-2650403.jpg?itok=mi1pySjM")
                .addField("CALLAITO", "value", false)
                .addField("\u200B", "\u200B", false)
                .addField("inline field", "value", true)
                .addField("inline field", "value", true)
                .addField("inline field", "value", true)
                .image("https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/hc_1440x810/public/media/image/2022/03/xokas-2650403.jpg?itok=mi1pySjM")
                .timestamp(Instant.now())
                .footer("footer", "https://cdn.hobbyconsolas.com/sites/navi.axelspringer.es/public/styles/hc_1440x810/public/media/image/2022/03/xokas-2650403.jpg?itok=mi1pySjM")
                .build();

        gateway.on(MessageCreateEvent.class).subscribe(event -> {
            final Message message = event.getMessage();
            if ("/embed".equals(message.getContent())) {
                final MessageChannel channel = message.getChannel().block();
                channel.createMessage(embed).block();
            }
        });

        gateway.onDisconnect().block();
    }
}







