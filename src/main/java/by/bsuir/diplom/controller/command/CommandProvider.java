package by.bsuir.diplom.controller.command;

import by.bsuir.diplom.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final Logger userLogger = LogManager.getLogger(CommandProvider.class);

    private Map<CommandName, Command> commands = new HashMap<>();


    public CommandProvider() {
        commands.put(CommandName.GO_TO_SIGN_IN_PAGE, new GoToSignInPage());
        commands.put(CommandName.GO_TO_SIGN_UP_PAGE, new GoToSignUpPage());
        commands.put(CommandName.SIGN_IN, new SignIn());
        commands.put(CommandName.SIGN_UP, new SignUp());
        commands.put(CommandName.GO_TO_HOME_PAGE, new GoToHomePage());
        commands.put(CommandName.EN_US, new ChangeLocale());
        commands.put(CommandName.RU_RU, new ChangeLocale());
        commands.put(CommandName.LOGOUT, new Logout());
        commands.put(CommandName.GO_TO_USERS_PAGE, new GoToUsersPage());
        commands.put(CommandName.DELETE_USER, new DeleteUser());
        commands.put(CommandName.GO_TO_EDIT_USER_PAGE, new GoToEditUserPage());
        commands.put(CommandName.GO_TO_COMPANY_PAGE, new GoToCompanyPage());
        commands.put(CommandName.FILTER_BY_LOCATION, new FilterByLocation());
        commands.put(CommandName.EDIT_USER, new EditUser());
        commands.put(CommandName.IMPORT_DATA, new ImportData());
        commands.put(CommandName.EXPORT_FULL_DATA, new ExportFullData());
        commands.put(CommandName.EXPORT_SEARCH_DATA, new ExportSearchData());
        commands.put(CommandName.GO_TO_EDIT_COMPANY_PAGE, new GoToEditCompanyPage());
        commands.put(CommandName.EDIT_COMPANY_INFO, new EditCompanyInfo());
        commands.put(CommandName.EDIT_STAFF, new EditStaff());
        commands.put(CommandName.EDIT_CAPITAL, new EditCapital());
        commands.put(CommandName.EDIT_EXPENSES, new EditExpenses());
        commands.put(CommandName.EDIT_COEFFICIENTS, new EditCoefficients());
        commands.put(CommandName.DELETE_COMPANY, new DeleteCompany());
        commands.put(CommandName.GO_TO_INDICATORS_PAGE, new GoToIndicatorsPage());
        commands.put(CommandName.GO_TO_CORRELATION_PAGE, new GoToCorrelationPage());
        commands.put(CommandName.WRONG_REQUEST, new WrongRequest());
        commands.put(CommandName.ADVANCED_SEARCH, new AdvancedSearch()); //My modification
    }

    public Command takeCommand(String name) {
        CommandName commandName;
        Command command;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = commands.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            String errorMessage = "Wrong command: " + name;
            userLogger.debug(errorMessage);
            command = commands.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
