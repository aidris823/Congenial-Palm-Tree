public class Particle{
      
    private double eCharge; 
    private double elMass; 
    private double prMass;
    private double ratio;
 
    public Particle(double ratio){
	//Constants
	eCharge = 1.6 * Math.pow(10,-19);
	elMass = 9.11 * Math.pow(10,-31);
	prMass = 1.67 * Math.pow(10,-27);
	this.ratio = ratio;
    }

    //Checks if the current ratio is kinda sorta close to the actual q / m ratio.
    private boolean isCloseEnough(double x){
	//30 is already VERY lenient, I think.
	return (Math.abs(x - ratio) <= 30);		   
    }

    private void print(double q, double m){
	System.out.println("Charge: " + q + " Coulombs"
			   + "\n" + "Mass: " + m + " Kilograms");
    }

    public void checkRatios(){
	boolean doesTeacherHateMe = true;
	for (int i = 1; i < 100; i++){
	    double ratio = i * eCharge / elMass;

	    //Tests for just the q changing
	    if (isCloseEnough(ratio)){
		print(i*eCharge,elMass);
		doesTeacherHateMe = false;
	    }
	    ratio = i * eCharge / prMass;
	    if (isCloseEnough(ratio)){
		print(i*eCharge,prMass);
		doesTeacherHateMe = false;
	    }

	    //Test for q changing AND either proton or electron changing.
	    for (int j = 1; j < 100; j++){
		ratio = (i * eCharge) / (j * elMass);
		if (isCloseEnough(ratio)){
		    print(i * eCharge, j * elMass);
		    doesTeacherHateMe = false;
		}
		    //Test for q changing AND both proton and electron changing.
		for (int k = 1; k < 100; k++){
		    ratio = (i * eCharge) / (j * elMass + k * prMass);
			if (isCloseEnough(ratio)){
			    print(i * eCharge, j * elMass + k * prMass);
			    doesTeacherHateMe = false;
			}
		}
		ratio = (i * eCharge) / (j * prMass);
		if (isCloseEnough(ratio)){
		    print(i * eCharge, j * prMass);
		    doesTeacherHateMe = false;
		}
		//Test for q changing AND both proton and electron changing.
		for (int k = 1; k < 100; k++){
		    ratio = (i * eCharge) / (j * prMass + k * elMass);
		    if (isCloseEnough(ratio)){
			print(i * eCharge, j * prMass + k * elMass);
			doesTeacherHateMe = false;
		    }
		}
	    }
	    
	}
	if (doesTeacherHateMe){
	    System.out.println("No possible values found.");
	}
    }
    public static void main(String[] arguments){


	Particle fmercury = new Particle(13793103.45);
	Particle bross = new Particle(95663265.31);
	Particle gkasparov = new Particle(47619047.62);
	Particle frogers = new Particle(10642826.73);
	Particle llzamenhof = new Particle(49309664.69);
	
	System.out.println("6. \n");
	fmercury.checkRatios();
	System.out.println("7. \n");
	bross.checkRatios();
	System.out.println("8. \n");
	gkasparov.checkRatios();
	System.out.println("9. \n");
	frogers.checkRatios();
        System.out.println("10. \n");
	llzamenhof.checkRatios();

	//Successful tests:
	7 and 9 only.
    }
}    
