import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    Response response = new Response();

    public String getBotUsername() {
        return "dutchman_password_bot";
    }

    public String getBotToken() {
        return "1522225653:AAGZIwYL0OOTpotF58ldT8YJ_mi1cpFklng";
    }

    public void onUpdateReceived(Update update) {
        String text = update.getMessage().getText();
        long chatID = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage().setChatId(chatID);
        if (text.equals("/start")) {
            sendMessage.setText("Hello and welcome to Dutchman Password Bot!\nThis Bot will help you to make your own password.");
            executeMessage(sendMessage);
            sendMessage.setText("Give me your name to make a password");
            executeMessage(sendMessage);
        } else {
            sendMessage.setText(response.sendMessage(update));
        }

    }

    public void executeMessage(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

