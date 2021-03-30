package by.tc.finalproject.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.tc.finalproject.controller.command.impl.GoToListOfApplicants;
import by.tc.finalproject.controller.command.impl.GoToLoginPage;
import by.tc.finalproject.controller.command.impl.GoToMainPage;
import by.tc.finalproject.controller.command.impl.CheckAdmissionResult;
import by.tc.finalproject.controller.command.impl.CreateListOfEnrolled;
import by.tc.finalproject.controller.command.impl.DeleteAccount;
import by.tc.finalproject.controller.command.impl.DeleteAccountFromAdmin;
import by.tc.finalproject.controller.command.impl.EditUserFromAdmin;
import by.tc.finalproject.controller.command.impl.Editing;
import by.tc.finalproject.controller.command.impl.Exit;
import by.tc.finalproject.controller.command.impl.GoToAdminPage;
import by.tc.finalproject.controller.command.impl.GoToEditPage;
import by.tc.finalproject.controller.command.impl.GoToEditUserFromAdmin;
import by.tc.finalproject.controller.command.impl.GoToPersonPage;
import by.tc.finalproject.controller.command.impl.GoToRegisterPage;
import by.tc.finalproject.controller.command.impl.Logination;
import by.tc.finalproject.controller.command.impl.Registration;
import by.tc.finalproject.controller.command.impl.transition.GoToAboutPage;
import by.tc.finalproject.controller.command.impl.transition.GoToContactPage;
import by.tc.finalproject.controller.command.impl.transition.GoToEFPage;
import by.tc.finalproject.controller.command.impl.transition.GoToFITUPage;
import by.tc.finalproject.controller.command.impl.transition.GoToFKPPage;
import by.tc.finalproject.controller.command.impl.transition.GoToFKSISPage;
import by.tc.finalproject.controller.command.impl.transition.GoToFRFPage;
import by.tc.finalproject.controller.command.impl.transition.GoToFacultyPage;
import by.tc.finalproject.controller.command.impl.transition.GoToInfoPage;
import by.tc.finalproject.controller.command.impl.transition.GoToNewsPage;

public class CommandProvider {
	private Map<CommandTitle, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put(CommandTitle.LOGINATION, new Logination());
		commands.put(CommandTitle.REGISTRATION, new Registration());
		commands.put(CommandTitle.GOTOADMINPAGE, new GoToAdminPage());
		commands.put(CommandTitle.GOTOPERSONPAGE, new GoToPersonPage());
		commands.put(CommandTitle.GOTOREGISTERPAGE, new GoToRegisterPage());
		commands.put(CommandTitle.GOTOLOGINPAGE, new GoToLoginPage());
		commands.put(CommandTitle.GOTOEDITPAGE, new GoToEditPage());
		commands.put(CommandTitle.EDITING, new Editing());
		commands.put(CommandTitle.DELETEACCOUNT, new DeleteAccount());
		commands.put(CommandTitle.GOTOLISTOFAPPLICANTS, new GoToListOfApplicants());
		commands.put(CommandTitle.DELETEACCOUNTFROMADMIN, new DeleteAccountFromAdmin());
		commands.put(CommandTitle.EDITUSERFROMADMIN, new EditUserFromAdmin());
		commands.put(CommandTitle.GOTOEDITUSERFROMADMIN, new GoToEditUserFromAdmin());
		commands.put(CommandTitle.CREATELISTOFENROLLED, new CreateListOfEnrolled());
		commands.put(CommandTitle.CHECKADMISSIONRESULT, new CheckAdmissionResult());

		commands.put(CommandTitle.GOTOMAINPAGE, new GoToMainPage());
		commands.put(CommandTitle.GOTOABOUTPAGE, new GoToAboutPage());
		commands.put(CommandTitle.GOTOFACULTYPAGE, new GoToFacultyPage());
		commands.put(CommandTitle.GOTOCONTACTPAGE, new GoToContactPage());
		commands.put(CommandTitle.GOTONEWSPAGE, new GoToNewsPage());
		commands.put(CommandTitle.GOTOEFPAGE, new GoToEFPage());
		commands.put(CommandTitle.GOTOFKSISPAGE, new GoToFKSISPage());
		commands.put(CommandTitle.GOTOINFOPAGE, new GoToInfoPage());
		commands.put(CommandTitle.GOTOFITUPAGE, new GoToFITUPage());
		commands.put(CommandTitle.GOTOFKPPAGE, new GoToFKPPage());
		commands.put(CommandTitle.GOTOFRPAGE, new GoToFRFPage());
		commands.put(CommandTitle.EXIT, new Exit());

	}

	public Command takeCommand(String name) {

		CommandTitle commandName = CommandTitle.valueOf(name.toUpperCase());
		return commands.get(commandName);

	}
}
