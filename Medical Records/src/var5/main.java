package var5;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {
    	
    	// New Scanner object for user input
        Scanner scanner = new Scanner(System.in); 
        MedicalRecords medicalRecords = new MedicalRecords();
        
        // infinite loop for menu options
        while (true) { 
        	
        	//Prompt user for option
        	System.out.println("Main Menu Options ");
        	System.out.println("=================");
            System.out.println("1. Add Patient ");
            System.out.println("2. Update Patient Record ");
            System.out.println("3. Remove Patient Record");
            System.out.println("4. Search for Patient Record");
            System.out.println("5. Display all records");
            System.out.println("6. Average age of patients");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            // Reads the user's choice as an integer
            int choice1 = scanner.nextInt();
            // Consumes the newline character
            scanner.nextLine();

            System.out.println("");
            
            //switch function for matin menu
            switch (choice1) {
            	
            	//menu options for adding patients
                case 1:
                	//Prompt user for option
                	System.out.println("Add Patient Menu Options ");
                	System.out.println("========================");
                    System.out.println("1. Add Patient ");
                    System.out.println("2. Add Inpatient ");
                    System.out.println("3. Add Outpatient ");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");

                    // Reads the user's choice as an integer
                    int choice2 = scanner.nextInt();
                    // Consumes the newline character
                    scanner.nextLine();

                    System.out.println("");
                    
                    //infinite loop for add Patient menu
                    while (choice2 != 0) {
                    	
                    	//switch function for Add Patient Menu
                        switch (choice2) {

                        // Add new Patient object, Prompt user for details
                        case 1:
                            System.out.println("Enter the Patient ID:");
                            String patientID = scanner.nextLine();
                            
                            System.out.println("Enter the Name:");
                            String name = scanner.nextLine();
                            
                            System.out.println("Enter the Age:");
                            int age = scanner.nextInt();
                            // Consume the newline character
                            scanner.nextLine(); 
                                                       
                            System.out.println("Enter the Gender (M/F):");
                            char gender = scanner.nextLine().charAt(0);
                            
                            System.out.println("Enter the Medical History:");
                            String medicalHistory = scanner.nextLine();
                            
                            //adds new patient object
                            Patient patient = new Patient(patientID, name, age, gender, medicalHistory);                        
                            medicalRecords.addPatient(patient);
                            
                            //prints user input
                            System.out.println("");
                            System.out.println("Patient added successfully.");
                            System.out.println("");
                            patient.disRec(medicalRecords);
                            System.out.println("");
                            
                            break;

                        // Add new Inpatient object, prompt user for details
                        case 2:
                            System.out.println("Enter the Patient ID:");
                            String inpatientID = scanner.nextLine();
                            
                            System.out.println("Enter the Name:");
                            String inpatientName = scanner.nextLine();
                            
                            System.out.println("Enter the Age:");
                            int inpatientAge = scanner.nextInt();
                            // Consume the newline character
                            scanner.nextLine(); 
                            
                            System.out.println("Enter the Gender (M/F):");
                            char inpatientGender = scanner.nextLine().charAt(0);
                            
                            System.out.println("Enter the Medical History:");
                            String inpatientMedicalHistory = scanner.nextLine();
                            
                            System.out.println("Enter the Admission Date:");
                            String admissionDate = scanner.nextLine();
                            
                            System.out.println("Enter the Estimated Stay:");
                            int estStay = scanner.nextInt();
                            
                            //add new Inpatient object
                            Inpatient inpatient = new Inpatient(inpatientID, inpatientName, inpatientAge, inpatientGender, inpatientMedicalHistory, admissionDate, estStay);
                            medicalRecords.addPatient(inpatient);
                            
                            //prints user input
                            System.out.println("");
                            System.out.println("Inpatient added successfully.");
                            System.out.println("");
                            inpatient.disRec(medicalRecords);
                            System.out.println("");
                            
                            break;

                            // Add new Outpatient object, prompts user for details
                            case 3:
                            	System.out.println("Enter the Patient ID:");
                                String outpatientID = scanner.nextLine();
                                
                                System.out.println("Enter the Name:");
                                String outpatientName = scanner.nextLine();
                                
                                System.out.println("Enter the Age:");
                                int outpatientAge = scanner.nextInt();
                                scanner.nextLine();
                                
                                System.out.println("Enter the Gender (M/F):");
                                char outpatientGender = scanner.nextLine().charAt(0);
                                
                                System.out.println("Enter the Medical History:");
                                String outpatientMedicalHistory = scanner.nextLine();
                                
                                System.out.println("Enter the Insurance Provider:");
                                String inProvider = scanner.nextLine();
                                
                                System.out.println("Enter the Insurance number:");
                                int inNum = scanner.nextInt();
                                scanner.nextLine();
                                
                                //adds new Outpatient Object
                                Outpatient outpatient = new Outpatient(outpatientID, outpatientName, outpatientAge, outpatientGender,outpatientMedicalHistory, inProvider, inNum);
                                medicalRecords.addPatient(outpatient);
                                
                                //prints user input
                                System.out.println("");
                                System.out.println("Outpatient added successfully.");
                                System.out.println("");
                                outpatient.disRec(medicalRecords);
                                System.out.println("");
                                
                                break;

                            // Exit to previous menu
                            case 0:
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;

                        }

                        System.out.println("1. Add Patient ");
                        System.out.println("2. Add Inpatient ");
                        System.out.println("3. Add Outpatient ");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");

                        choice2 = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("");
                    }
                    break;
                
                //menu options for updating patient information
                case 2:
                	System.out.println("Update Patient Menu Options ");
                	System.out.println("===========================");
                    System.out.println("1. Update Patient Record ");
                    System.out.println("2. Update Inpatient Record ");
                    System.out.println("3. Update Outpatient Record ");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");

                    // Reads the user's choice as an integer
                    choice2 = scanner.nextInt();
                    // Consumes the newline character
                    scanner.nextLine();

                    System.out.println("");

                    while (choice2 != 0) {

                        switch (choice2) {

                     // Add update Patient object based on PatientID
                        case 1:
                            System.out.print("Enter Patient ID: ");
                            String patientID = scanner.nextLine();
                            //returns patient object, null if not found
                            Patient patient = medicalRecords.searchPatientByID(patientID);
                            
                            if (patient != null) {
                                // Update Patient attributes
                                System.out.print("Enter Name: ");
                                String name = scanner.nextLine();
                                patient.setName(name);

                                System.out.print("Enter Age: ");
                                int age = scanner.nextInt();
                                patient.setAge(age);

                                System.out.print("Enter Gender: ");
                                char gender = scanner.next().charAt(0);
                                patient.setGender(gender);

                                System.out.print("Enter Medical History: ");
                                // Consumes the newline character
                                scanner.nextLine(); 
                                String medicalHistory = scanner.nextLine();
                                patient.setMedicalHistory(medicalHistory);
                                
                                //prints user input
                                System.out.println("");
                                System.out.println("Patient record updated successfully.");
                                System.out.println("");
                                patient.disRec(medicalRecords);
                                System.out.println("");
                                
                            } else {
                                System.out.println("Patient not found.");
                            }
                            break;

                        // Add update Inpatient object based on PatientID
                        case 2:
                            System.out.print("Enter Patient ID: ");
                            String inpatientID = scanner.nextLine();
                            //returns inpatient object, null if not found
                            Inpatient inpatient = (Inpatient) medicalRecords.searchPatientByID(inpatientID);

                            if (inpatient != null) {
                                // Update Inpatient attributes
                            	System.out.println("Enter Name: ");
                            	String newName = scanner.nextLine();
                            	inpatient.setName(newName);
                            	
                            	System.out.println("Enter Age: ");
                            	int newAge = scanner.nextInt();
                            	inpatient.setAge(newAge);
                            	
                            	System.out.print("Enter Gender: ");
                                char newGender = scanner.next().charAt(0);
                                inpatient.setGender(newGender);

                                System.out.print("Enter Medical History: ");
                                // Consumes the newline character
                                scanner.nextLine(); 
                                String newMedicalHistory = scanner.nextLine();
                                inpatient.setMedicalHistory(newMedicalHistory);
                            	
                                System.out.print("Enter Admission Date: ");
                                String admissionDate = scanner.nextLine();
                                inpatient.setAdmissionDate(admissionDate);

                                System.out.print("Enter Estimated Stay: ");
                                int estStay = scanner.nextInt();
                                inpatient.setEstStay(estStay);
                                
                                //prints user input
                                System.out.println("");
                                System.out.println("Inpatient record updated successfully.");
                                System.out.println("");
                                inpatient.disRec(medicalRecords);
                                System.out.println("");
                            } else {
                                System.out.println("Inpatient not found.");
                            }
                            break;

                        // Add update Outpatient object based on PatientID
                        case 3:
                            System.out.print("Enter Patient ID: ");
                            String outpatientID = scanner.nextLine();
                            //returns outpatient object, null if not found                            
                            Outpatient outpatient = (Outpatient) medicalRecords.searchPatientByID(outpatientID);

                            if (outpatient != null) {
                                // Update Outpatient attributes
                            	
                            	System.out.println("Enter Name: ");
                            	String newName = scanner.nextLine();
                            	outpatient.setName(newName);
                            	
                            	System.out.println("Enter Age: ");
                            	int newAge = scanner.nextInt();
                            	outpatient.setAge(newAge);
                            	
                            	System.out.print("Enter Gender: ");
                                char newGender = scanner.next().charAt(0);
                                outpatient.setGender(newGender);

                                System.out.print("Enter Medical History: ");
                                // Consumes the newline character
                                scanner.nextLine(); 
                                String newMedicalHistory = scanner.nextLine();
                                outpatient.setMedicalHistory(newMedicalHistory);
                                
                                System.out.print("Enter Insurance Provider: ");
                                String inProvider = scanner.nextLine();
                                outpatient.setInProvider(inProvider);

                                System.out.print("Enter Insurance Number: ");
                                int inNum = scanner.nextInt();
                                outpatient.setInNum(inNum);
                                
                                
                                //prints user input
                                System.out.println("");
                                System.out.println("Outpatient record updated successfully.");
                                System.out.println("");
                                outpatient.disRec(medicalRecords);
                                System.out.println("");
                            } else {
                                System.out.println("Outpatient not found.");
                            }
                            break;

                        // Exit to previous menu
                        case 0:
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;

                        }

                        System.out.println("1. Update Patient Record ");
                        System.out.println("2. Update Inpatient Record ");
                        System.out.println("3. Update Outpatient Record ");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");

                        choice2 = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("");
                    }
                    break;
                
                //menu options for removing a patient record
                case 3:
                	System.out.println("Remove Patient Menu Options ");
                	System.out.println("============================");
                    System.out.println("1. Remove Patient Record ");
                    System.out.println("2. Remove Inpatient Record ");
                    System.out.println("3. Remove Outpatient Record ");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");

                    // Reads the user's choice as an integer
                    choice2 = scanner.nextInt();
                    // Consumes the newline character
                    scanner.nextLine();

                    System.out.println("");

                    while (choice2 != 0) {

                        switch (choice2) {

                            //removing a Patient record
                            case 1:
                                System.out.print("Enter Patient ID: ");
                                String patientID = scanner.nextLine();
                                boolean patientRemoved = medicalRecords.removePatientByID(patientID);
                                
                                if (patientRemoved) {
                                    System.out.println("Patient record removed successfully.");
                                } else {
                                    System.out.println("Patient not found.");
                                }
                                break;

                            // removing an Inpatient record
                            case 2:
                                System.out.print("Enter Inpatient ID: ");
                                String inpatientID = scanner.nextLine();
                                boolean inpatientRemoved = medicalRecords.removePatientByID(inpatientID);

                                if (inpatientRemoved) {
                                    System.out.println("Inpatient record removed successfully.");
                                } else {
                                    System.out.println("Inpatient not found.");
                                }
                                break;

                            // removing an Outpatient record
                            case 3:
                                System.out.print("Enter Outpatient ID: ");
                                String outpatientID = scanner.nextLine();
                                boolean outpatientRemoved = medicalRecords.removePatientByID(outpatientID);

                                if (outpatientRemoved) {
                                    System.out.println("Outpatient record removed successfully.");
                                } else {
                                    System.out.println("Outpatient not found.");
                                }
                                break;

                            // Exit to previous menu
                            case 0:
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                                break;
                        }

                        System.out.println("1. Remove Patient Record ");
                        System.out.println("2. Remove Inpatient Record ");
                        System.out.println("3. Remove Outpatient Record ");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");

                        choice2 = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("");
                    }

                    break;
                
                //menu opotions for searching a patient
                case 4:
                	
                	System.out.println("Search Patient Menu Options ");
                	System.out.println("===========================");
                    System.out.println("1. Search for Patient Record ");
                    System.out.println("2. Search for Inpatient Record ");
                    System.out.println("3. Search for Outpatient Record ");
                    System.out.println("0. Exit");
                    System.out.print("Enter your choice: ");

                    // Reads the user's choice as an integer
                    choice2 = scanner.nextInt();
                    // Consumes the newline character
                    scanner.nextLine();

                    System.out.println("");

                    while (choice2 != 0) {

                    	switch (choice2) {
                        // Searching a Patient record
                        case 1:
                            System.out.println("Enter the Patient ID:");
                            String patientID = scanner.nextLine();
                            //returns patient object if found, else null
                            Patient patient = medicalRecords.searchPatientByID(patientID);
                            if (patient != null) {
                            	//display patient information
                                patient.disRec(medicalRecords);
                            } else {
                                System.out.println("Patient not found.");
                            }
                            break;

                        // Searching an Inpatient record
                        case 2:
                            System.out.println("Enter the Patient ID:");
                            patientID = scanner.nextLine();
                            //returns inpatient object if found, else null
                            Inpatient inpatient = (Inpatient)medicalRecords.searchPatientByID(patientID);
                            if (inpatient != null) {
                            	//display inpatient information
                                inpatient.disRec(medicalRecords);
                            } else {
                                System.out.println("Inpatient not found.");
                            }
                            break;

                        // Searching an Outpatient record
                        case 3:
                            System.out.println("Enter the Patient ID:");
                            patientID = scanner.nextLine();
                          //returns outpatient object if found, else null
                            Outpatient outpatient = (Outpatient)medicalRecords.searchPatientByID(patientID);
                            if (outpatient != null) {
                            	//display outpatient information
                                outpatient.disRec(medicalRecords);
                            } else {
                                System.out.println("Outpatient not found.");
                            }
                            break;

                        // Exit to previous menu
                        case 0:
                            break;

                        default:
                            System.out.println("Invalid choice. Please try again.");
                            break;
                    }


                        System.out.println("1. Search for Patient Record ");
                        System.out.println("2. Search for Inpatient Record ");
                        System.out.println("3. Search for Outpatient Record ");
                        System.out.println("0. Exit");
                        System.out.print("Enter your choice: ");

                        choice2 = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("");
                    }

                    break;
                //print all patient records
                case 5:
                    
                	medicalRecords.printAllRecords();
                    break;
                
                //Average age of all patients
                case 6:
                	medicalRecords.handlePatientCollection(medicalRecords.getPatientList());
                	break;
                
                case 0:
                    // Exit the program
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;

            }
        }
    }
}
