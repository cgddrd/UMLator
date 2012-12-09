import java.io.*;

public class WriteTest {

	public WriteTest() {
	
	}

	public static void main(String[] args) throws Exception{
		WriteTest write = new WriteTest();
		write.printOut(5,6);
	}
	
	
		
	public void printOut(int varNo, int opNo) throws Exception{
	PrintWriter out = new PrintWriter(new FileWriter("C:\\outputfile.java"));
	out.write("public class TestClass {\r\n");
	out.write("\r\n");
	
	for (int i = 0; i < varNo; i++) {
		out.write("	private String test;\r\n");
		out.write("\r\n");
	}
	
	for (int i = 0; i < opNo; i++) {
		out.write("\r\n");
		out.write("	public void methTest() {\r\n");
		out.write("\r\n");
		out.write("	}\r\n");
	}
	
	out.write("}");
	//out.write("world");
	out.close();
	}
}
