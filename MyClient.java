import java.io.*;
import java.net.*;

public class MyClient{
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;
	
	public MyClient(){
		try{
			//s=new Socket("43.240.7.180",10);
			s=new Socket("localhost",10);
			System.out.println(s);
			
			dis= new DataInputStream(s.getInputStream());
			dos= new DataOutputStream(s.getOutputStream());
			
			clientChat();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void clientChat()throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		do{
			str=br.readLine();
			dos.writeUTF(str);
			dos.flush();
			System.out.println("Sever message : "+dis.readUTF());
		}while(!str.equals("stop"));
	}
	public static void main(String sq1[])
	{
		new MyClient();
	}

}