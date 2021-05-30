package work0530_inheritance;

public class ISAInheritance {

	public static void main(String[] args) {
		NotebookComp nc =new NotebookComp("이수영",5);
		TabletNotebook tn = new TabletNotebook("정수영",5,"ISE-241-242");
		nc.movingCal();
		tn.write("ISE-241-242");
	}

}
