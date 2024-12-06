# Final Project: Hospital Data Application
## Authors: Priscilla Zavala, Ikanke Inyang, Asante Anglin, Toni Benson

### Project Summary:
This application enables users to log in and authenticate based on their credentials for one of the following roles: Cost Analyst, Auditor, HR Director, or Medicaid Analyst. After logging in, users select a position-specific task to access relevant hospital data. Users can specify a state and hospital ID to retrieve data from a hospital data API. The application fetches and displays the data, allowing users to view how the information has changed over time.

***

### 2 Possible Program Interfaces:
#### CLI (Command-Line Interface)
Users can interact with the program via the command line, specifying their role, task, state, and hospital ID to retrieve and view data.
#### GUI (Graphic User Interface)
A graphical interface is available for users who prefer a visual experience. It provides the same functionality as the CLI, but with an intuitive layout and visual chart representations of the data for better understanding and analysis.

***

### Features:
* User Authentication: Login based on role-specific credentials (Cost Analyst, Auditor, HR Director, Medicaid Analyst).
* Task Selection: After logging in, users select a position-specific task to access relevant hospital data.
* State & Hospital Data: Retrieve data based on state and hospital ID input from the user.
* Data Export: Export hospital data to a CSV file for offline use or further analysis.
* Data Visualization: Visual representations of data over time (bar chart, scatter plot) with JavaFX.
* CLI & GUI Support: The program can be run both via a command-line interface (CLI) and a graphical user interface (GUI).
* Historical Data Viewing: View how the hospital data has changed over the years.

***

### Build Instructions:
##### Clone the Respository
Clone the respository to your local machine
##### Running the CLI
To run the CLI version of the application, navigate to the Main class and execute the main function.
##### Running the GUI
To run the GUI version, go to the Gradle tasks directory, then navigate to:
Tasks -> Application and double-click run to launch the application as a JVM application.  
##### Known Issue (GUI State Selection Bug)  
There is a known bug when selecting a state in the GUI. To select a state, you must first click a different state and then select the desired one. This issue is currently being debugged, but the application works as intended once the correct state is selected.
##### API Access Key Setup
1. The program requires an API access key. Please request the key directly.
2. Create a .env file at the project root and enter your API key in the following format: API_KEY=access-key-here     
* Alternatively, you can create this file under the resources folder inside the main directory for better organization.

***

### Controller Warning Suppressions:
The following controllers include warning suppressions for Action and Mouse Events:
- Controller
- LoginController
- MenuController
- CostAnalystController
- AuditorController
- HRDirectorController
- MedicaidAnalystController

*** 

## Project Structure:
#### Model Layer     
Responsible for data retrieval, controlling program flow, and configuration:
- AuditorController
- AuditorModel
- BuildURL
- Controller
- CostAnalystController
- CostAnalystModel
- HRDirectorController
- HRDirectorModel
- InStateModel
- JSONDocParser
- JSONReaderFormatter
- LoginController
- MedicaidAnalystController
- MedicaidAnalystModel
- MenuController
- PositionModel
- TaskSpecificationModel
- UserCredentialModel
- UserModel
- ExportCSV
  
#### View Layer     
Manages the user interface and view-related logic:
- TaskOptions
- AuditorView
- CostAnalystView
- HRDirectorView
- MedicaidAnalystView
- ErrorProcessor
- InStateModelView
- PositionViewUserView
- StateAbbreviation

### Utility Classes   
Handles common reusable tasks in the program:
- AlertUtils
- BarChartControllerUtils
- ScatterChartControllerUtils
- StringUtils

### URL Connection Classes   
Facilitates live connections to the hospital API:   
- WebsiteURLConnection
