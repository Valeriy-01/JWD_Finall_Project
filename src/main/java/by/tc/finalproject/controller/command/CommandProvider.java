package by.tc.finalproject.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.tc.finalproject.controller.command.impl.GoToIndexPage;
import by.tc.finalproject.controller.command.impl.GoToListOfApplicants;
import by.tc.finalproject.controller.command.impl.GoToLoginPage;
import by.tc.finalproject.controller.command.impl.DeleteAccount;
import by.tc.finalproject.controller.command.impl.Editing;
import by.tc.finalproject.controller.command.impl.GoToAdminPage;
import by.tc.finalproject.controller.command.impl.GoToEditPage;
import by.tc.finalproject.controller.command.impl.GoToPersonPage;
import by.tc.finalproject.controller.command.impl.GoToRegisterPage;
import by.tc.finalproject.controller.command.impl.Logination;
import by.tc.finalproject.controller.command.impl.Logout;
import by.tc.finalproject.controller.command.impl.Registration;

public class CommandProvider {
	private Map<CommandTitle, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandTitle.LOGINATION, new Logination());
		commands.put(CommandTitle.REGISTRATION, new Registration());
		commands.put(CommandTitle.LOGOUT, new Logout());
		commands.put(CommandTitle.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandTitle.GOTOADMINPAGE, new GoToAdminPage());
		commands.put(CommandTitle.GOTOPERSONPAGE, new GoToPersonPage());
		commands.put(CommandTitle.GOTOREGISTERPAGE, new GoToRegisterPage());
		commands.put(CommandTitle.GOTOLOGINPAGE, new GoToLoginPage());
		commands.put(CommandTitle.GOTOEDITPAGE, new GoToEditPage());
		commands.put(CommandTitle.EDITING, new Editing());
		commands.put(CommandTitle.DELETEACCOUNT, new DeleteAccount());
		commands.put(CommandTitle.GOTOLISTOFAPPLICANTS, new GoToListOfApplicants());

	}

	public Command takeCommand(String name) {

		CommandTitle commandName = CommandTitle.valueOf(name.toUpperCase());
		return commands.get(commandName);

	}
}
