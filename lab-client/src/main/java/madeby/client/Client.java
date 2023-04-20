package madeby.client;

import madeby.client.util.Console;
import madeby.common.Exception.DontCorrectJsonException;
import madeby.common.util.CollectionManager;
import madeby.common.util.CommandManager;
import madeby.common.util.InputManager;
import madeby.common.util.OutputManager;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.NoSuchElementException;

public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {

        final OutputManager outputManager = new OutputManager();

        if (args.length == 0) {
            outputManager.println("This program needs a file in argument to work with.");
            return;
        }

        if (!args[0].endsWith(".xml")) {
            outputManager.println("This program can only work with .json file.");
            return;
        }
        try (InputManager inputManager = new InputManager()) {

            final CollectionManager collectionManager = new CollectionManager();
            final CommandManager commandManager = new CommandManager(args[0], inputManager, collectionManager, outputManager);
            final Console console = new Console(args[0], outputManager, collectionManager, inputManager,
                    commandManager);
            try {
                console.start();
            } catch (IOException e) {
                outputManager.println("Could not read the file. Check if it is available.");
                e.printStackTrace();
            } catch (JAXBException | IllegalArgumentException e) {
                outputManager.println("The file does not keep data in correct format.");
            } catch (NoSuchElementException e) {
                outputManager.println("EOF");
            } catch (DontCorrectJsonException e) {
                outputManager.print(e.getMessage() + '\n');
            }
        }
    }
}
