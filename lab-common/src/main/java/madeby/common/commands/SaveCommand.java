package madeby.common.commands;

import madeby.common.util.CollectionManager;
import madeby.common.util.XmlUtils;

import javax.xml.bind.JAXBException;

public class SaveCommand extends Command {
    private final CollectionManager collectionManager;
    private final String path;

    public SaveCommand(CollectionManager collectionManager, String path) {
        this.collectionManager = collectionManager;
        this.path = path;
    }

    @Override
    public CommandResult execute(String arg) {
        try {
            XmlUtils xmlUtils = new XmlUtils();
            xmlUtils.serialize(collectionManager.getDataCollection(), path);
        } catch (JAXBException e) {
            return new CommandResult("There was a problem saving a file. Please restart the program with another one");
        }
        return new CommandResult("The data was saved successfully");
    }
}
