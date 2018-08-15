import java.sql.*;
import java.util.Scanner;
class Manager extends TaxiMangeSystem{
	public void manage()
	{
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****����Ա����*****");
		System.out.println("\t1.��������");
		System.out.println("\t2.˾������");
		System.out.println("\t3.�鿴��ͬ");
		System.out.println("\t4.Υ�����");
		System.out.println("\t5.�鿴�������");
		System.out.println("\t6.�˳�");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t***��������볤�ȣ�������ѡ��***\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
	switch(choice)
	{
	case '1':car_manage();manage();break;
	case '2':driver_manage();manage();break;
	case '3':check_rent();manage();break;
	case '4':illegal_manage();manage();break;
	case '5':chuche_imformation();manage();break;
	case '6':break;
	default:System.out.println("\t***�����ѡ��������ѡ��***\n\n");System_window();break;
	}
	}
	//������Ϣ�����鿴���г��⳵����������³��⳵
	public void car_manage()
	{
		//System.out.println("\tcar_manage()");
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****�����������*****");
		System.out.println("\t1.�鿴���г��⳵��Ϣ");
		System.out.println("\t2.�����µĳ��⳵");	
		System.out.println("\t3.����");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t*****��������볤�ȣ�������ѡ��*****\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
		switch(choice)
		{
		case '1':
			//���г��⳵��Ϣ
			car_imformation();
			car_manage();break;
		case '2':
			//�����µĳ��⳵
			car_insert();
			car_manage();break;
		case '3':break;
		default:System.out.println("\t*****�����ѡ��������ѡ��*****\n\n");car_manage();break;
		}	
	}
	public void driver_imformation()
	{
		Manager m=new Manager();
		Connection conn=m.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select * from driver");
			ResultSet rs=st.executeQuery(sql);
			System.out.print("\n\t˾����\t\t���֤��\t\t���պ�\t\t����\t�Ա�\t��֤ʱ��\t\t����\t�������\n");
			while(rs.next())
			{
				System.out.print("\t"+rs.getString(1));
				System.out.print("\t"+rs.getString(3));
				System.out.print("\t"+rs.getString(4));
				System.out.print("\t"+rs.getString(5));
				System.out.print("\t"+rs.getString(6));
				System.out.print("\t"+rs.getString(7));
				System.out.print("\t"+rs.getString(8));
				System.out.print("\t"+"  "+rs.getString(9)+"\n");
			}
			
		}
		catch (Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
		}
	}
	//��ָ��������ѯָ��˾��
	public void driver_select()
	{
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\t*****ָ��˾����ѯ*****");
		System.out.println("\t1.����˾���Ų���");
		System.out.println("\t2.������������");
		System.out.println("\t3.�����Ա����");
		System.out.println("\t4.���ݼ������");
		System.out.println("\t5.����");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t*****��������볤�ȣ�������ѡ��*****\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
	try{	
		
		Manager m=new Manager();
		Connection conn=m.connect();
		Statement st=conn.createStatement();
		String sql;
		ResultSet rs;
		switch(choice)
		{
		case '1':
			//����˾���Ų���
			System.out.print("����˾���ţ�");
			String id;
			id=sc.next();
			sql="select * from driver where did="+id;
			rs=st.executeQuery(sql);
			if(rs.next()){
			System.out.print("\n˾����\t\t���֤��\t\t���պ�\t\t����\t�Ա�\t��֤ʱ��\t\t����\t�������\n");
			System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getString(6));
			System.out.print("\t"+rs.getString(7));
			System.out.print("\t"+rs.getString(8));
			System.out.print("\t"+"  "+rs.getString(9)+"\n");
			}
			else System.out.println("û���ҵ�˾����Ϊ��"+id+"����˾����");
			driver_select();
			break;
		case '2':
			//������������
			System.out.print("����������");
			String name;
			name=sc.next();
			sql="select * from driver where dname='"+name+"'";
			rs=st.executeQuery(sql);
			if(rs.next()){
			System.out.print("\n˾����\t\t���֤��\t\t���պ�\t\t����\t�Ա�\t��֤ʱ��\t\t����\t�������\n");
			System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getString(6));
			System.out.print("\t"+rs.getString(7));
			System.out.print("\t"+rs.getString(8));
			System.out.print("\t"+"  "+rs.getString(9)+"\n");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(3));
				System.out.print("\t"+rs.getString(4));
				System.out.print("\t"+rs.getString(5));
				System.out.print("\t"+rs.getString(6));
				System.out.print("\t"+rs.getString(7));
				System.out.print("\t"+rs.getString(8));
				System.out.print("\t"+"  "+rs.getString(9)+"\n");
			}
			}
			else System.out.println("û���ҵ�����Ϊ��"+name+"����˾����");
			driver_select();
			break;
		case '3':
			//�����Ա����
			System.out.print("�����Ա��л�Ů����");
			String sex;
			sex=sc.next();
			sql="select * from driver where sex='"+sex+"'";
			rs=st.executeQuery(sql);
			if(rs.next()){
			System.out.print("\n˾����\t\t���֤��\t\t���պ�\t\t����\t�Ա�\t��֤ʱ��\t\t����\t�������\n");
			System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getString(6));
			System.out.print("\t"+rs.getString(7));
			System.out.print("\t"+rs.getString(8));
			System.out.print("\t"+"  "+rs.getString(9)+"\n");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(3));
				System.out.print("\t"+rs.getString(4));
				System.out.print("\t"+rs.getString(5));
				System.out.print("\t"+rs.getString(6));
				System.out.print("\t"+rs.getString(7));
				System.out.print("\t"+rs.getString(8));
				System.out.print("\t"+"  "+rs.getString(9)+"\n");
			}
			}
			//else System.out.println("û���ҵ�˾����Ϊ��"+id+"��˾����");
			driver_select();
			break;
		case '4':
			//���ݼ������
			System.out.print("�������޼��䣨����ѯ���м���С����������˾������");
			String dage;
			dage=sc.next();
			int age=Integer.parseInt(dage);
			sql="select * from driver where driveage<"+age;
			rs=st.executeQuery(sql);
			if(rs.next()){
			System.out.print("\n˾����\t\t���֤��\t\t���պ�\t\t����\t�Ա�\t��֤ʱ��\t\t����\t�������\n");
			System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getString(6));
			System.out.print("\t"+rs.getString(7));
			System.out.print("\t"+rs.getString(8));
			System.out.print("\t"+"  "+rs.getString(9)+"\n");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(3));
				System.out.print("\t"+rs.getString(4));
				System.out.print("\t"+rs.getString(5));
				System.out.print("\t"+rs.getString(6));
				System.out.print("\t"+rs.getString(7));
				System.out.print("\t"+rs.getString(8));
				System.out.print("\t"+"  "+rs.getString(9)+"\n");
			}
			}
			driver_select();
			break;
		case '5':break;
		default:System.out.println("\t*****�����ѡ��������ѡ��*****\n\n");driver_select();break;
		}	
		}
		catch (Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
	}
	}
	
	//ǩԼ�µ�˾��
	public void driver_newone()
	{
		Manager m=new Manager();
		Connection conn=m.connect();
		Scanner sc=new Scanner(System.in);
		String idno=new String();
		String licenceid=new String();
		String dname=new String();
		String sex=new String();
		String licencedate=new String();
		String driveage=new String();

		try{
			Statement st=conn.createStatement();
			ResultSet rs;
			//���Ȳ�ѯ�Ƿ���δ����ĳ����ɹ����ޣ������������������û������ʾ��Ϣ
			String sql="select min(carid) from car where isRent=0;";
			rs=st.executeQuery(sql);
			if(!rs.next())//û�п������޵ĳ���
			{
				System.out.println("���е����г��⳵���Գ��⣬��ʣ��ĳ����ɹ����ޣ�");
				return;
			}
			String min_carid;
			min_carid=rs.getString(1);
			int cid=Integer.parseInt(min_carid);//cid����������޵ĳ����У����ƺ���С����һ��
			System.out.println("��ѯ���г��ƺ�Ϊ��"+cid+"���ĳ��⳵�ɹ����⣡");
			//��ȡ˾���ĳ�����Ϣ
			System.out.print("����˾��������");
			dname=sc.next();
			
			System.out.print("����˾���Ա�");
			sex=sc.next();
			
			System.out.print("����˾�����֤�ţ�");
			idno=sc.next();
			
			System.out.print("����˾�����պţ�");
			licenceid=sc.next();
			
			System.out.print("����˾���õ����յ����ڣ�");
			licencedate=sc.next();
			
			System.out.print("����˾�����䣺");
			driveage=sc.next();
			
			//��driver���л�ȡ���е�����˾���ţ���ʹ���һ��������˾��
			sql="select max(did) from driver ";
			rs=st.executeQuery(sql);
			rs.next();
			String driverid=rs.getString(1);
			int did=Integer.parseInt(driverid);
			did+=1;//didΪ��˾����˾����
			System.out.println("\n���ԣ���Ҫ�����˾����Ϊ"+did);
			/*
			 ���ž�����driver���в����˾���ˣ���Ҫע�⣬������˾����ʹ��car��driver���Լ�rentmessage������ͬʱ����
			car���б��˴����޵ĳ�����isRent���Ե�ֵҪ�޸�Ϊ1
			rentmessage��Ҫ���ݴ˴εĳ��ƺ��Լ�˾���ţ�����һ���µ����޺�ͬ��Ϣ
			*/
			
			//����car��
			sql="update car set isRent=1 where carid="+cid;
			st.executeUpdate(sql);
	//		System.out.println("\n���ԣ�car����³ɹ�!");
			//����˾����driver��
			sql="insert into driver(did,carid,idno,licenceid,dname,sex,licencedate,driveage) values("+did+","+cid+",'"+idno+"','"+licenceid+"','"+dname+"','"+sex+"','"+licencedate+"',"+driveage+");";
	//		System.out.println("���ԣ�driver�Ĳ������Ϊ "+sql);
			st.executeUpdate(sql);
	//		System.out.println("\n���ԣ�driver�����ɹ�!");
			//�����ͬ��rentmessage��
			//����Ҫ�ҵ�rentmessage��rentid���ֵ��ʹ���һ��ɱ������޵��ĵ���
			sql="select max(rentid) from rentmessage";
			rs=st.executeQuery(sql);
			rs.next();
			String rentid=rs.getString(1);
			int rid=Integer.parseInt(rentid);
			rid+=1;
	//		System.out.println("\n���ԣ��µ����޵���ͬidΪ"+rid);
			sql="insert into rentmessage(rentid,did,carid) values("+rid+","+did+","+cid+")";
			st.executeUpdate(sql);
	//		System.out.println("\n���ԣ�rentmessage�����ɹ�!");
			
			System.out.println("�µ�˾�����޺�ͬ��Ч��");
		}
		catch(Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
		}
		
	}
	
	//˾����Ϣ���������鿴����˾������Ϣ������ԵĲ�ѯĳ����ĳϵ�е�˾���������µ�˾��
	public void driver_manage()
	{
		//System.out.println("\tdriver_manage()");
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****˾���������*****");
		System.out.println("\t1.�鿴����˾����Ϣ");
		System.out.println("\t2.��������ѯ˾��");
		System.out.println("\t3.��˾��ǩ�����޺�ͬ");
		System.out.println("\t4.����");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t*****��������볤�ȣ�������ѡ��*****\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
		switch(choice)
		{
		case '1':
			//����˾����Ϣ
			driver_imformation();
			driver_manage();
			break;
		case '2':
			//����Բ���˾��
			driver_select();
			driver_manage();
			break;
		case '3':
			//ǩ���º�ͬ
			driver_newone();
			driver_manage();
			break;
		case '4':break;
		default:System.out.println("\t*****�����ѡ��������ѡ��*****\n\n");driver_manage();break;
		}	
	}
	public void check_rent()
	{
		//System.out.println("\tcheck_rent()");
		Manager m=new Manager();
		Connection conn=m.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select * from rentmessage");
			ResultSet rs=st.executeQuery(sql);
			System.out.print("\n������\t\t˾����\t\t���ƺ�\t\t��ʼ����\t\t��������\t\t���(Ԫ)\t���գ�Ԫ��\t\n");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(2));
				System.out.print("\t"+rs.getString(3));
				System.out.print("\t"+rs.getString(4));
				System.out.print("\t"+rs.getString(5));
				System.out.print("\t"+rs.getString(6));
				System.out.print("\t"+rs.getString(7)+"\n");
				
			}
			
		}
		catch (Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
		}
	}
	
	//�鿴������
	public void chuche_imformation()
	{
		Manager m=new Manager();
		Connection conn=m.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select * from logsheet");
			ResultSet rs=st.executeQuery(sql);
			System.out.print("\n��������\t\t˾����\t\t���ƺ�\t\t��������\n");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(2));
				System.out.print("\t"+rs.getString(3));
				System.out.println("\t"+rs.getString(4));
				
				
			}
			
		}
		catch (Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
		}
	}
	
	//Υ����������鿴Υ�������˾���ĳ�����ɸ���
	public void illegal_manage()
	{
		//System.out.println("\tillegal_manage()");
		System.out.println("\n\t*****���������е�Υ�����******");
	//	System.out.println("\t˾����\t˾������\t���ƺ�\t����\t����\tΥ��ʱ��\t\tΥ��ص�\t\t����");
		Manager m=new Manager();
		Connection conn=m.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select driver.did,driver.dname,car.carid,car.cartype,driver.isallow,illegalnotes.punishment," +
					"illegalnotes.illegaltime,illegalnotes.address,illegalnotes.detail from " +
					"car,driver,illegalnotes where driver.did=illegalnotes.did and car.carid=illegalnotes.carid" +
					" order by driver.did");
			ResultSet rs=st.executeQuery(sql);
			System.out.println("˾����\t\t˾������\t���ƺ�\t\t����\t\t�������\t\t����\tΥ��ʱ��\t\tΥ��ص�\t\t����");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(2));
				System.out.print("\t"+rs.getString(3));
				System.out.print("\t"+rs.getString(4));
				System.out.print("\t"+rs.getString(5));
				System.out.print("\t\t"+rs.getString(6));
				System.out.print("\t"+rs.getString(7));
				System.out.print("\t"+rs.getString(8));
				System.out.print("\t"+rs.getString(9)+"\n");
			}
			System.out.println("\n���Զ�����Υ���˾�����г������Ȩ�޵ĸ��ģ�1.�޸�˾������Ȩ�ޣ�2.����");
			Scanner sc=new Scanner(System.in);
			String input=new String();
			char choice;
			input=sc.next();
			choice=input.charAt(0);
			while((input.length()>1||input.length()<=0))
		{
			System.out.println("\t*****��������볤�ȣ�������ѡ��*****\n\n");
			input=sc.next();
			choice=input.charAt(0);
		}
			switch(choice)
			{
			case '1':
				System.out.println("����Ҫ�޸ĳ���Ȩ�޵�˾����˾���ţ�");
				input=sc.next();
				sql="select driver.did,driver.dname,driver.isallow from driver,illegalnotes where driver.did=illegalnotes.did" +
						" and driver.did="+input+";";
				rs=st.executeQuery(sql);
				if(rs.next())
				{
					System.out.println("����ѯ,˾����Ϊ��\""+rs.getString(1)+"\"�������Ϊ��\""+
							rs.getString(3)+"\"��˾��( "+rs.getString(2)+")��Υ�������\n");
					System.out.println("1.�޸ĳ���Ȩ�� 2.����");
					String flag=rs.getString(3);
					String did=rs.getString(1);
					String allow="0";
					if(flag.equals(allow))allow="1";
					input=sc.next();
					choice=input.charAt(0);
					while((input.length()>1||input.length()<=0))
				{
					System.out.println("\t*****��������볤�ȣ�������ѡ��*****\n\n");
					input=sc.next();
					choice=input.charAt(0);
				}
					switch(choice)
					{
					case '1':
						sql="update driver set isallow="+allow+" where did="+did;
						st.executeUpdate(sql);
						System.out.println("*****��������޸ĳɹ���*****\n");
						break;
					case '2':
						break;
					default:System.out.println("\t*****�����ѡ��������ѡ��*****\n\n");driver_manage();break;
					}	
				}
				else System.out.println("*****���޸�˾���Ŷ�Ӧ��˾��!*****\n");
				
				break;
			case '2':
				break;
			default:System.out.println("\t*****�����ѡ��������ѡ��*****\n\n");driver_manage();break;
			}	
		}
		catch (Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
		}
	}
	
	//�����ǰ���ݿ��б�Car�е����г�����Ϣ
	public void car_imformation()
	{
		Manager m=new Manager();
		Connection conn=m.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select * from car");
			ResultSet rs=st.executeQuery(sql);
			System.out.print("\n���ƺ�\t\t����\t\t��ɫ\t��������\t\t����\t�������\n");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(2));
				System.out.print("\t"+rs.getString(3));
				System.out.print("\t"+rs.getString(4));
				System.out.print("\t"+rs.getString(5));
				System.out.print("\t"+"   "+rs.getString(6)+"\n");
			}
			
		}
		catch (Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
		}
	}
	
	//���Car�������µĳ��������ݣ�������һ��������
	public void car_insert()
	{
		String carid=new String();
		String cartype=new String();
		String color=new String();
		String buydate=new String();
		String carstate=new String();	
		Scanner sc=new Scanner(System.in);
		Manager m=new Manager();
		Connection conn=m.connect();
		try{
			Statement st=conn.createStatement();
			String sql_1=new String("select MAX(carid) from car");
			ResultSet rs=st.executeQuery(sql_1);
			if(rs.next())carid=rs.getString(1);
			int id=Integer.parseInt(carid);
			id+=1;
			System.out.print("\n�����복�ͣ����糤��-����������-�ִ���:");
			cartype=sc.next();
			System.out.print("�����복����ɫ��������̡����ף�:");
			color=sc.next();
			System.out.print("�����빺�����ڣ�����2015-07-08��:");
			buydate=sc.next();
			System.out.print("�����복�����������á�һ�㡢ά�ޣ���");
			carstate=sc.next();
			String sql_2=new String("insert into car(carid,cartype,color,buydate,carstate) values ("+id+",'"+cartype+"','"+color+"','"+buydate+"','"+carstate+"');");
			st.executeUpdate(sql_2);
			//�������
			System.out.println("\n*****����ɹ�*****\n�µĳ��⳵��Ϣ��\n"+id+","+cartype+","+color+","+buydate+","+carstate);
		}
		catch (Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
		}
	}
}

class Driver extends TaxiMangeSystem
{
	public void driver_imformation(String did)
	{
		Driver d=new Driver();
		Connection conn=d.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select did,car.carid,idno,licenceid,dname,sex,licencedate,driveage,isallow," +
					"cartype,color,carstate from driver,car where did="+did+" and driver.carid=car.carid;");
			ResultSet rs=st.executeQuery(sql);
			rs.next();
				System.out.println("\n\t*****˾����Ϣ(˾����Ϊ��"+did+")*****");
				System.out.println("\t˾���ţ�\t\t"+rs.getString(1));
				System.out.println("\t���֤�ţ�\t"+rs.getString(3));
				System.out.println("\t���պţ�\t\t"+rs.getString(4));
				System.out.println("\t������\t\t"+rs.getString(5));
				System.out.println("\t�Ա�\t\t"+rs.getString(6));
				System.out.println("\t��֤ʱ�䣺\t"+rs.getString(7));
				System.out.println("\t���䣺\t\t"+rs.getString(8));
				System.out.println("\t������ɣ�\t"+rs.getString(9));
				System.out.println("\t���ƺţ�\t\t"+rs.getString(2));
				System.out.println("\t���ͣ�\t\t"+rs.getString(10));
				System.out.println("\t��ɫ��\t\t"+rs.getString(11));
				System.out.println("\t������\t\t"+rs.getString(12));
		}
		catch (Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
		}
	}
	public void driver_rentimformation(String did)
	{
		Driver d=new Driver();
		Connection conn=d.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select * from rentmessage where did="+did);
			ResultSet rs=st.executeQuery(sql);
			System.out.print("\n������\t\t˾����\t\t���ƺ�\t\t��ʼ����\t\t��������\t\t���(Ԫ)\t���գ�Ԫ��\t\n");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(2));
				System.out.print("\t"+rs.getString(3));
				System.out.print("\t"+rs.getString(4));
				System.out.print("\t"+rs.getString(5));
				System.out.print("\t"+rs.getString(6));
				System.out.print("\t"+rs.getString(7)+"\n");
				
			}
			
		}
		catch (Exception e){
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
		}
	}
	public void up_chuche(String did)
	{
		Driver d=new Driver();
		Connection conn=d.connect();
		try{
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****˾����������(˾����Ϊ��"+did+")*****");
		
		Statement st=conn.createStatement();
		ResultSet rs;
		String sql="select isallow from driver where did="+did;
		rs=st.executeQuery(sql);
		rs.next();
		String isallow=rs.getString(1);
		
		if(isallow.equals("1"))
		{
		System.out.println("\t1.ȷ�ϳ���");
		System.out.println("\t2.����");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t***��������볤�ȣ�������ѡ��***\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
	switch(choice)
	{
	case '1':
		sql="select carid from driver where did="+did;
		rs=st.executeQuery(sql);
		rs.next();
		String carid=rs.getString(1);
		
		sql="select max(logid) from logsheet";
		rs=st.executeQuery(sql);
		rs.next();
		String lid=rs.getString(1);
		int logid=Integer.parseInt(lid);
		logid+=1;
		lid=Integer.toString(logid);
		
		sql=new String("insert into logsheet(logid,did,carid) values("+lid+","+did+","+carid+");");
//		System.out.println("����"+sql);
		st.executeUpdate(sql);
		System.out.println("*****�����ɹ����ѵ���ϵͳ�ڵĳ�����*****\n");
		break;
	case '2':
		break;
	default:System.out.println("\t***�����ѡ��������ѡ��***\n\n");System_window();break;
	}
		}
		else System.out.println("\n\n\t*****�޳���Ȩ�ޣ�******\n");
		}
	catch (Exception e){
		e.printStackTrace();
	}
		
	}
	
	//˾����ϵͳ�ύΥ����Ϣ
	public void up_illegal(String did)
	{
		Driver d=new Driver();
		Connection conn=d.connect();
		try{
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****�Ͻ�Υ����Ϣ����(˾����Ϊ��"+did+")*****");
		System.out.println("\t1.�Ͻ�Υ����Ϣ");
		System.out.println("\t2.����");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t***��������볤�ȣ�������ѡ��***\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
	switch(choice)
	{
	case '1':
		Statement st=conn.createStatement();
		ResultSet rs;
		String sql="select carid from driver where did="+did;
		rs=st.executeQuery(sql);
		rs.next();
		String carid=rs.getString(1);//�ҵ�did��Ӧ��carid
		
		sql="select max(illegalid) from illegalnotes";
		rs=st.executeQuery(sql);
		rs.next();
		String illegalid=rs.getString(1);
		int ilid=Integer.parseInt(illegalid);
		ilid+=1;
		illegalid=Integer.toString(ilid);//����Υ�浥����	
		
		System.out.println("���뷣�֣�");
		String punishment=sc.next();
		
		System.out.println("����Υ�����ڣ�yyyy-mm-dd����");
		String illegaldate=sc.next();
		
		System.out.println("���뷢���ص㣺");
		String address=sc.next();
		
		System.out.println("����Υ�����飺");
		String detail=sc.next();
		
		sql=new String("insert into illegalnotes values("+illegalid+","+did+","+carid+","+punishment+",'"+illegaldate+"','"+
				address+"','"+detail+"')");
		
//		System.out.println("����"+sql);
		st.executeUpdate(sql);
		System.out.println("*****�Ͻ��ɹ���Υ����Ϣ�ѵ���ϵͳ�ڵ�Υ���*****\n");
		break;
	case '2':
		break;
	default:System.out.println("\t***�����ѡ��������ѡ��***\n\n");System_window();break;
	}
		}
	catch (Exception e){
		e.printStackTrace();
	}
	}
	public void manage(String did)
	{
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****˾������(˾����Ϊ��"+did+")*****");
		System.out.println("\t1.�鿴������Ϣ");
		System.out.println("\t2.�鿴��ͬ��Ϣ");
		System.out.println("\t3.����");
		System.out.println("\t4.�ύΥ����Ϣ");
		System.out.println("\t5.�˳�");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t***��������볤�ȣ�������ѡ��***\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
	switch(choice)
	{
	case '1':driver_imformation(did);manage(did);break;
	case '2':driver_rentimformation(did);manage(did);break;
	case '3':up_chuche(did);manage(did);break;
	case '4':up_illegal(did);manage(did);break;
	default:System.out.println("\t***�����ѡ��������ѡ��***\n\n");System_window();break;
	}
	}
}

public class TaxiMangeSystem {
	public static final String url = "jdbc:mysql://localhost:3306/taximanage?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&amp";
	public static final String name = "com.mysql.cj.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "jswang";
	//���ڽ������ݿ������
	public Connection connect()
	{
		try {
			Connection con=null;
			Class.forName(name);//ָ����������1
			con = DriverManager.getConnection(url, user, password);//��ȡ����
			//pst = conn.prepareStatement(sql);//׼��ִ�����
			//System.out.println("Connect succeed!");
			return con;
		} catch (Exception e) {
			//System.out.println("Connect failed!");
			e.printStackTrace();
			return null;
		}
	}
	//���ڹر����ݿ������
	public void close(Connection c)
	{
		try {
			c.close();
			System.out.println("Connect closed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//��������Manager��manage()�������й������
	public void manage()
	{
		//System.out.println("����Ա����");
		Manager m=new Manager();
		m.manage();
	}
	//��������Driver��һϵ�з������в���
	public void driver(String did)
	{
		//System.out.println("˾������");
		Driver d=new Driver();
		d.manage(did);
	}
	//��������ʹ�ø�ϵͳ���û�������Ա��˾��
	public void login(int distinguish)
	{
		boolean flag=false;
		Scanner sc=new Scanner(System.in);
		String in=new String();
		TaxiMangeSystem t=new TaxiMangeSystem();
		Connection conn=t.connect(); 
	try{	
		Statement st = conn.createStatement();
		if(distinguish==1)
		{
			System.out.print("���������Ա�˺ţ�");
			in=sc.next();
			String sql=new String("select account,pwd from manager" );
			ResultSet rs = st.executeQuery(sql);
		/*	while(rs.next()){
				System.out.println(rs.getString(1)+rs.getString(2));
			}*/
			while(rs.next()){
				if(in.equals(rs.getString(1)))
				{
					System.out.print("���������룺");
					in=sc.next();
					if(in.equals(rs.getString(2)))
					{
						flag=true;
						manage();
					}
				}
			
			}
			if(!flag)System.out.println("\t*****��½ʧ��--�˺Ų����ڻ��������*****");
		}
		
		else if(distinguish==2)
		{
			System.out.print("������˾���ţ�");
			in=sc.next();
			String sql=new String("select did,idno from driver" );
			ResultSet rs = st.executeQuery(sql);
		/*	while(rs.next()){
				System.out.println(rs.getString(1)+rs.getString(2));
			}*/
			while(rs.next()){
				if(in.equals(rs.getString(1)))
				{
					String did=in;
					System.out.print("���������֤�ţ�");
					in=sc.next();
					if(in.equals(rs.getString(2)))
					{
						flag=true;
						driver(did);
					}
				}
			
			}
			if(!flag)System.out.println("\t*****��½ʧ��--˾���Ų����ڻ����֤�Ŵ���*****");
		}
		}
		catch (Exception e) {
			System.out.println("���ݿ�����쳣��");
			e.printStackTrace();
	}
	//��ϵͳ����Ҫ���
	}
	public void System_window()
	{
		System.out.println("\n\tѡ���û���ݻ��˳���\n\t1.����Ա\n\t2.˾��\n\t3.�˳�");
		String input=new String();
		char choice;
		Scanner sc=new Scanner(System.in);
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t*****��������볤�ȣ�������ѡ��*****\n\n");
		System.out.println("\tѡ���û���ݻ��˳���\n\t1.����Ա\n\t2.˾��\n\t3.�˳�");
		input=sc.next();
		choice=input.charAt(0);
	}
	switch(choice)
	{
	case '1':login(1);System_window();break;
	case '2':login(2);System_window();break;
	case '3':break;
	default:System.out.println("\t*****�����ѡ��������ѡ��*****\n\n");System_window();break;
	}
	}
	//�������������������еĿ�ʼ�����
	public static void main(String args[])
	{
		TaxiMangeSystem taxi=new TaxiMangeSystem();
		taxi.System_window();
		System.out.println("���н�����");
		
	}
}
