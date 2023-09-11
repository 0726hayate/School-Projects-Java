package var5;

class Patient {
	
	private String PatientID;
	private String Name;
	private int Age;
	private char Gender;
	private String MedicalHistory;
	
	
	public Patient(String PatientID, String Name, int Age, char Gender, String MedicalHistory) {
		this.PatientID = PatientID;
		this.Name = Name;
		this.Age = Age;
		this.Gender = Gender;
		this.MedicalHistory = MedicalHistory;
	}
	
	// Getter and Setter methods for attributes
		public String getPatientID() {
			return PatientID;
		}
		
		public void setPatientID(String PatientID) {
			this.PatientID = PatientID;
		}
		
		public String getName() {
			return Name;
		}
		
		public void setName(String Name) {
			this.Name = Name;
		}
		
		public int getAge() {
			return Age;
		}
		
		public void setAge(int Age) {
			this.Age = Age;
		}
		
		public char getGender() {
			return Gender;
		}
		
		public void setGender(char Gender) {
			this.Gender = Gender;
		}
		
		public String getMedicalHistory() {
			return MedicalHistory;
		}
		
		public void setMedicalHistory(String MedicalHistory) {
			this.MedicalHistory = MedicalHistory;
		}
		
		//display Patient attributes
		public void disRec(MedicalRecords medicalRecords) {
			//if patient object is found
			Patient foundPatient = medicalRecords.searchPatientByID(this.PatientID);
	        if (foundPatient != null) {
	            System.out.println("Patient ID: " + foundPatient.getPatientID());
	            System.out.println("Name: " + foundPatient.getName());
	            System.out.println("Age: " + foundPatient.getAge());
	            System.out.println("Gender: " + foundPatient.getGender());
	            System.out.println("Medical History: " + foundPatient.getMedicalHistory());
	        } else {
	            System.out.println("Patient not found.");
	        }
		}
		

}

//
class Inpatient extends Patient{
		
	private String admissionDate;
	private int estStay;
		
	public Inpatient(String PatientID, String Name, int Age, char Gender, String MedicalHistory, String admissionDate, int estStay) {
		super(PatientID, Name, Age, Gender, MedicalHistory);
		this.admissionDate = admissionDate;
		this.estStay = estStay;
	}
		
	//Additional methods and attributes specific to Inpatient
	public String getAdmissionDate() {
		return admissionDate;
	}
		
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
			
	}
	public int getEstStay() {
			
		return estStay;
	}
	public void setEstStay(int estStay) {
		this.estStay = estStay;
	}
	
	//override the disRec method to provide custom information for inpatient
	@Override
	public void disRec(MedicalRecords medicalRecords) {
		//check if ID matches by calling serachPatientByID that returns patient object if found and null if not
	    Inpatient foundPatient = (Inpatient) medicalRecords.searchPatientByID(getPatientID());
	    
	    if (foundPatient != null) {
	    	System.out.println("Patient ID: " + foundPatient.getPatientID());
            System.out.println("Name: " + foundPatient.getName());
            System.out.println("Age: " + foundPatient.getAge());
            System.out.println("Gender: " + foundPatient.getGender());
            System.out.println("Medical History: " + foundPatient.getMedicalHistory());
	        System.out.println("Admission Date: " + foundPatient.getAdmissionDate());
	        System.out.println("Estimated stay time: " + foundPatient.getEstStay());
	    } else {
	        System.out.println("Patient not found.");
	    }
	}
		
}

class Outpatient extends Patient{
	
	private String inProvider;
	private int inNum;
		
	public Outpatient(String PatientID, String Name, int Age, char Gender, String MedicalHistory, String inProvider, int inNum) {
		super(PatientID, Name, Age, Gender, MedicalHistory);
		this.inProvider = inProvider;
		this.inNum = inNum;
	}
		
	//Additional methods and attributes specific to Outpatient
	public String getInProvider() {
		return inProvider;
	}
		
	public void setInProvider(String inProvider) {
		this.inProvider = inProvider;
			
	}
	public int getInNum() {
			
		return inNum;
	}
	public void setInNum(int inNum) {
		this.inNum = inNum;
	}
	
	//override the disRec method to provide custom information for Outpatient
	@Override
	public void disRec(MedicalRecords medicalRecords) {
		//check if ID matches by calling serachPatientByID that returns patient object if found and null if not
	    Outpatient foundPatient = (Outpatient) medicalRecords.searchPatientByID(getPatientID());
	    //if patient object is found
	    if (foundPatient != null) {
	    	System.out.println("Patient ID: " + foundPatient.getPatientID());
            System.out.println("Name: " + foundPatient.getName());
            System.out.println("Age: " + foundPatient.getAge());
            System.out.println("Gender: " + foundPatient.getGender());
            System.out.println("Medical History: " + foundPatient.getMedicalHistory());
	        System.out.println("Insurance Provider: " + foundPatient.getInProvider());
	        System.out.println("Insurance Number: " + foundPatient.getInNum());
	    } else {
	        System.out.println("Patient not found.");
	    }
	}
		
}
	
	
