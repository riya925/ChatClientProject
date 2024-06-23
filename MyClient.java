import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class MyClient
{
	public static void main(String[] args)
	{
		try
		{
			Socket server=new Socket("localhost",1234); //local host is domain name and ip address is 127.0.0.1 for same machine
			
			DataInputStream dis=new DataInputStream(server.getInputStream());
			DataOutputStream dos=new DataOutputStream(server.getOutputStream());
			
			Scanner scan=new Scanner(System.in);
			String str="";
			
			//str=dis.readUTF();
			//System.out.println("\n From Server : "+str);
			
			while(!str.equals("QUIT"))
			{
				str=dis.readUTF();
				System.out.println("\n FROM SERVER : "+str);
				
				System.out.println("\n MSG FOR SERVER : ");
				str=scan.nextLine();
				dos.writeUTF(str);
			}
			
			dis.close();
			dos.close();
			server.close();
		}
		catch(Exception e)
		{
			System.out.println("\n CLIENT ERROR : "+e.getMessage());
		}
	}
}
