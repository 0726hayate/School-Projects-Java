# Medical Records Management System
This Java program, along with the supporting classes main.java, MedicalRecords.java, and Patient.java, is a Medical Records Management System that allows users to perform various tasks related to managing patient records. The program is designed to be run in a command-line interface and provides a menu-driven interface for interacting with the system.

## Features
1. Add Patient Records
+ Users can add new patient records, including general patients, inpatients, and outpatients.
+ For each patient type, relevant information such as name, age, gender, medical history, admission date (for inpatients), estimated stay (for inpatients), insurance provider (for outpatients), and insurance number (for outpatients) can be entered.
2. Update Patient Records
+ Users can update the information of existing patient records, including general patients, inpatients, and outpatients.
+ Information such as name, age, gender, and medical history can be modified for each patient type.
3. Remove Patient Records
+ Users can remove patient records from the system by specifying the patient ID.
4. Search for Patient Records
+ Users can search for patient records by providing the patient ID.
+ The program displays the patient's information if found, including general patients, inpatients, and outpatients.
5. Display All Patient Records
+ Users can view a list of all patient records in the system.
6. Calculate Average Age of Patients
+ Users can calculate the average age of all patients in the system.
7. Exit
+ Users can exit the program.
## Usage
1. Run the program in a Java environment.
2. The program presents a menu with various options.
3. Choose an option by entering the corresponding number and follow the prompts to perform the desired task.
4. Repeat as needed, and use the "0. Exit" option to exit the program.
## Class Structure

### main.java
This class contains the main program logic, including the menu system for interacting with the Medical Records Management System.

### MedicalRecords.java
This supporting class contains methods and data structures for managing patient records. It includes:

+ A list of patients (patientList) to store patient records.
+ Methods for adding, updating, and removing patient records.
+ A method for searching for patient records by ID.
+ A method for printing all patient records.
+ A method for calculating the average age of patients.
  
### Patient.java
This class represents a general patient and includes attributes such as patient ID, name, age, gender, and medical history. It also provides methods to access and modify these attributes. Additionally, it includes a method to display patient attributes.

#### Inpatient.java
This class extends the Patient class and represents an inpatient. It includes attributes specific to inpatients such as admission date and estimated stay. It overrides the disRec method to provide custom information for inpatients.

### Outpatient.java
This class also extends the Patient class and represents an outpatient. It includes attributes specific to outpatients such as insurance provider and insurance number. It overrides the disRec method to provide custom information for outpatients.
