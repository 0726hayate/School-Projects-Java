package var5;
import java.util.ArrayList;
import java.util.List;

class MedicalRecords {
	
	private List<Patient> patientList;
	
	public MedicalRecords() {
		this.patientList = new ArrayList<>();
	}
	
	//getter method for patient list
	public List<Patient> getPatientList() {
	    return patientList;
	}
	
	//method to add patient to the system
	public void addPatient(Patient patient) {
		patientList.add(patient);
	}
	
	//Method to update student details, ID should only be assigned once so not included to avoid changing it
	public void updateRecord(Patient patient, String Name, int Age,char Gender, String History) {
		patient.setName(Name);
		patient.setAge(Age);
		patient.setGender(Gender);
		patient.setMedicalHistory(History);
		
	}
	
	//Method to remove Patient and returns true/false to print out correct message in main
	public boolean removePatientByID(String patientID) {
		//go through patient list
	    for (Patient patient : patientList) {
	    	//checks if ID matches
	        if (patient.getPatientID().equals(patientID)) {
	        	//remove patient
	            patientList.remove(patient);
	            return true;
	        }
	    }
	    return false;
	}
	
	//Method to search for patient record, since name could be changed or have typos, search by ID only
	public Patient searchPatientByID(String patientID) {
		//go through patient list
	    for (Patient patient : patientList) {
	    	//check if ID matches and returns patient object
	        if (patient.getPatientID().equals(patientID)) {
	            return patient;
	        }
	    }
	    //patient not found
	    return null; 
	}
	
	//Method to print all Patient Records
	public void printAllRecords() {
		//go through patient list and print
		for(Patient patient : patientList) {
			//print current instance
			patient.disRec(this);
			System.out.println("");
		}
		
	}
	
	// Method that utilizes generics to handle a collection of patients
	public <T extends Patient> void handlePatientCollection(List<T> patients) {
		//keep track of total number of patients
	    int totalPatients = patients.size();
	    
	    int totalMalePatients = 0;
	    int totalFemalePatients = 0;
	    int totalAge = 0;
	    
	    //go through all patients
	    for (T patient : patients) {
	    	//add ages of all patients
	        totalAge += patient.getAge();
	        
	        //counts number of male and female patients
	        if (patient.getGender() == 'M') {
	            totalMalePatients++;
	        } else if (patient.getGender() == 'F') {
	            totalFemalePatients++;
	        }
	    }
	    
	    //calculates average age of all patients
	    double averageAge = (double) totalAge / totalPatients;
	    
	    
	    System.out.println("Total Patients: " + totalPatients);
	    System.out.println("Total Male Patients: " + totalMalePatients);
	    System.out.println("Total Female Patients: " + totalFemalePatients);
	    System.out.println("Average Age: " + averageAge);
	}
}
