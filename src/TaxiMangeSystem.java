import java.sql.*;
import java.util.Scanner;
class Manager extends TaxiMangeSystem{
	public void manage()
	{
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****管理员界面*****");
		System.out.println("\t1.车辆管理");
		System.out.println("\t2.司机管理");
		System.out.println("\t3.查看合同");
		System.out.println("\t4.违规管理");
		System.out.println("\t5.查看出车情况");
		System.out.println("\t6.退出");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t***错误的输入长度，请重新选择***\n\n");
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
	default:System.out.println("\t***错误的选择，请重新选择***\n\n");System_window();break;
	}
	}
	//车辆信息管理，查看现有出租车情况，增加新出租车
	public void car_manage()
	{
		//System.out.println("\tcar_manage()");
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****车辆管理界面*****");
		System.out.println("\t1.查看现有出租车信息");
		System.out.println("\t2.增加新的出租车");	
		System.out.println("\t3.返回");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t*****错误的输入长度，请重新选择*****\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
		switch(choice)
		{
		case '1':
			//现有出租车信息
			car_imformation();
			car_manage();break;
		case '2':
			//增加新的出租车
			car_insert();
			car_manage();break;
		case '3':break;
		default:System.out.println("\t*****错误的选择，请重新选择*****\n\n");car_manage();break;
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
			System.out.print("\n\t司机号\t\t身份证号\t\t驾照号\t\t姓名\t性别\t发证时间\t\t驾龄\t出车许可\n");
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
			System.out.println("数据库操作异常！");
			e.printStackTrace();
		}
	}
	//按指定条件查询指定司机
	public void driver_select()
	{
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\t*****指定司机查询*****");
		System.out.println("\t1.根据司机号查找");
		System.out.println("\t2.根据姓名查找");
		System.out.println("\t3.根据性别查找");
		System.out.println("\t4.根据驾龄查找");
		System.out.println("\t5.返回");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t*****错误的输入长度，请重新选择*****\n\n");
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
			//根据司机号查找
			System.out.print("输入司机号：");
			String id;
			id=sc.next();
			sql="select * from driver where did="+id;
			rs=st.executeQuery(sql);
			if(rs.next()){
			System.out.print("\n司机号\t\t身份证号\t\t驾照号\t\t姓名\t性别\t发证时间\t\t驾龄\t出车许可\n");
			System.out.print(rs.getString(1));
			System.out.print("\t"+rs.getString(3));
			System.out.print("\t"+rs.getString(4));
			System.out.print("\t"+rs.getString(5));
			System.out.print("\t"+rs.getString(6));
			System.out.print("\t"+rs.getString(7));
			System.out.print("\t"+rs.getString(8));
			System.out.print("\t"+"  "+rs.getString(9)+"\n");
			}
			else System.out.println("没有找到司机号为”"+id+"“的司机！");
			driver_select();
			break;
		case '2':
			//根据姓名查找
			System.out.print("输入姓名：");
			String name;
			name=sc.next();
			sql="select * from driver where dname='"+name+"'";
			rs=st.executeQuery(sql);
			if(rs.next()){
			System.out.print("\n司机号\t\t身份证号\t\t驾照号\t\t姓名\t性别\t发证时间\t\t驾龄\t出车许可\n");
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
			else System.out.println("没有找到姓名为”"+name+"“的司机！");
			driver_select();
			break;
		case '3':
			//根据性别查找
			System.out.print("输入性别（男或女）：");
			String sex;
			sex=sc.next();
			sql="select * from driver where sex='"+sex+"'";
			rs=st.executeQuery(sql);
			if(rs.next()){
			System.out.print("\n司机号\t\t身份证号\t\t驾照号\t\t姓名\t性别\t发证时间\t\t驾龄\t出车许可\n");
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
			//else System.out.println("没有找到司机号为："+id+"的司机！");
			driver_select();
			break;
		case '4':
			//根据驾龄查找
			System.out.print("输入上限驾龄（将查询所有驾龄小于输入驾龄的司机）：");
			String dage;
			dage=sc.next();
			int age=Integer.parseInt(dage);
			sql="select * from driver where driveage<"+age;
			rs=st.executeQuery(sql);
			if(rs.next()){
			System.out.print("\n司机号\t\t身份证号\t\t驾照号\t\t姓名\t性别\t发证时间\t\t驾龄\t出车许可\n");
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
		default:System.out.println("\t*****错误的选择，请重新选择*****\n\n");driver_select();break;
		}	
		}
		catch (Exception e){
			System.out.println("数据库操作异常！");
			e.printStackTrace();
	}
	}
	
	//签约新的司机
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
			//首先查询是否还有未出租的车辆可供租赁，如果有则继续处理，如果没有则提示信息
			String sql="select min(carid) from car where isRent=0;";
			rs=st.executeQuery(sql);
			if(!rs.next())//没有可以租赁的车了
			{
				System.out.println("现有的所有出租车均以出租，无剩余的车辆可供租赁！");
				return;
			}
			String min_carid;
			min_carid=rs.getString(1);
			int cid=Integer.parseInt(min_carid);//cid代表可以租赁的车辆中，车牌号最小的那一辆
			System.out.println("查询到有车牌号为“"+cid+"”的出租车可供出租！");
			//获取司机的常规信息
			System.out.print("输入司机姓名：");
			dname=sc.next();
			
			System.out.print("输入司机性别：");
			sex=sc.next();
			
			System.out.print("输入司机身份证号：");
			idno=sc.next();
			
			System.out.print("输入司机驾照号：");
			licenceid=sc.next();
			
			System.out.print("输入司机拿到驾照的日期：");
			licencedate=sc.next();
			
			System.out.print("输入司机驾龄：");
			driveage=sc.next();
			
			//从driver表中获取已有的最大的司机号，并使其加一后分配给新司机
			sql="select max(did) from driver ";
			rs=st.executeQuery(sql);
			rs.next();
			String driverid=rs.getString(1);
			int did=Integer.parseInt(driverid);
			did+=1;//did为新司机的司机号
			System.out.println("\n测试：将要分配的司机号为"+did);
			/*
			 接着就是向driver表中插入该司机了，但要注意，插入新司机会使得car，driver，以及rentmessage三个表同时更新
			car表中被此次租赁的车辆的isRent属性的值要修改为1
			rentmessage则要根据此次的车牌号以及司机号，插入一行新的租赁合同信息
			*/
			
			//更新car表
			sql="update car set isRent=1 where carid="+cid;
			st.executeUpdate(sql);
	//		System.out.println("\n测试：car表更新成功!");
			//插入司机到driver表
			sql="insert into driver(did,carid,idno,licenceid,dname,sex,licencedate,driveage) values("+did+","+cid+",'"+idno+"','"+licenceid+"','"+dname+"','"+sex+"','"+licencedate+"',"+driveage+");";
	//		System.out.println("测试：driver的插入语句为 "+sql);
			st.executeUpdate(sql);
	//		System.out.println("\n测试：driver表插入成功!");
			//插入合同到rentmessage表
			//首先要找到rentmessage中rentid最大值，使其加一变成本次租赁单的单号
			sql="select max(rentid) from rentmessage";
			rs=st.executeQuery(sql);
			rs.next();
			String rentid=rs.getString(1);
			int rid=Integer.parseInt(rentid);
			rid+=1;
	//		System.out.println("\n测试：新的租赁单合同id为"+rid);
			sql="insert into rentmessage(rentid,did,carid) values("+rid+","+did+","+cid+")";
			st.executeUpdate(sql);
	//		System.out.println("\n测试：rentmessage表插入成功!");
			
			System.out.println("新的司机租赁合同生效！");
		}
		catch(Exception e){
			System.out.println("数据库操作异常！");
			e.printStackTrace();
		}
		
	}
	
	//司机信息管理，包括查看所有司机的信息，针对性的查询某个或某系列的司机，增加新的司机
	public void driver_manage()
	{
		//System.out.println("\tdriver_manage()");
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****司机管理界面*****");
		System.out.println("\t1.查看现有司机信息");
		System.out.println("\t2.按条件查询司机");
		System.out.println("\t3.新司机签订租赁合同");
		System.out.println("\t4.返回");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t*****错误的输入长度，请重新选择*****\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
		switch(choice)
		{
		case '1':
			//现有司机信息
			driver_imformation();
			driver_manage();
			break;
		case '2':
			//针对性查找司机
			driver_select();
			driver_manage();
			break;
		case '3':
			//签订新合同
			driver_newone();
			driver_manage();
			break;
		case '4':break;
		default:System.out.println("\t*****错误的选择，请重新选择*****\n\n");driver_manage();break;
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
			System.out.print("\n订单号\t\t司机号\t\t车牌号\t\t开始日期\t\t结束日期\t\t租金(元)\t保险（元）\t\n");
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
			System.out.println("数据库操作异常！");
			e.printStackTrace();
		}
	}
	
	//查看出车表
	public void chuche_imformation()
	{
		Manager m=new Manager();
		Connection conn=m.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select * from logsheet");
			ResultSet rs=st.executeQuery(sql);
			System.out.print("\n出车单号\t\t司机号\t\t车牌号\t\t出车日期\n");
			while(rs.next())
			{
				System.out.print(rs.getString(1));
				System.out.print("\t"+rs.getString(2));
				System.out.print("\t"+rs.getString(3));
				System.out.println("\t"+rs.getString(4));
				
				
			}
			
		}
		catch (Exception e){
			System.out.println("数据库操作异常！");
			e.printStackTrace();
		}
	}
	
	//违规管理，包括查看违规情况和司机的出车许可更改
	public void illegal_manage()
	{
		//System.out.println("\tillegal_manage()");
		System.out.println("\n\t*****以下是所有的违规情况******");
	//	System.out.println("\t司机号\t司机姓名\t车牌号\t车型\t罚分\t违规时间\t\t违规地点\t\t详情");
		Manager m=new Manager();
		Connection conn=m.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select driver.did,driver.dname,car.carid,car.cartype,driver.isallow,illegalnotes.punishment," +
					"illegalnotes.illegaltime,illegalnotes.address,illegalnotes.detail from " +
					"car,driver,illegalnotes where driver.did=illegalnotes.did and car.carid=illegalnotes.carid" +
					" order by driver.did");
			ResultSet rs=st.executeQuery(sql);
			System.out.println("司机号\t\t司机姓名\t车牌号\t\t车型\t\t出车许可\t\t罚分\t违规时间\t\t违规地点\t\t详情");
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
			System.out.println("\n可以对上述违规的司机进行出车许可权限的更改：1.修改司机出车权限，2.返回");
			Scanner sc=new Scanner(System.in);
			String input=new String();
			char choice;
			input=sc.next();
			choice=input.charAt(0);
			while((input.length()>1||input.length()<=0))
		{
			System.out.println("\t*****错误的输入长度，请重新选择*****\n\n");
			input=sc.next();
			choice=input.charAt(0);
		}
			switch(choice)
			{
			case '1':
				System.out.println("输入要修改出车权限的司机的司机号：");
				input=sc.next();
				sql="select driver.did,driver.dname,driver.isallow from driver,illegalnotes where driver.did=illegalnotes.did" +
						" and driver.did="+input+";";
				rs=st.executeQuery(sql);
				if(rs.next())
				{
					System.out.println("经查询,司机号为：\""+rs.getString(1)+"\"出车许可为：\""+
							rs.getString(3)+"\"的司机( "+rs.getString(2)+")有违规情况。\n");
					System.out.println("1.修改出车权限 2.返回");
					String flag=rs.getString(3);
					String did=rs.getString(1);
					String allow="0";
					if(flag.equals(allow))allow="1";
					input=sc.next();
					choice=input.charAt(0);
					while((input.length()>1||input.length()<=0))
				{
					System.out.println("\t*****错误的输入长度，请重新选择*****\n\n");
					input=sc.next();
					choice=input.charAt(0);
				}
					switch(choice)
					{
					case '1':
						sql="update driver set isallow="+allow+" where did="+did;
						st.executeUpdate(sql);
						System.out.println("*****出车许可修改成功！*****\n");
						break;
					case '2':
						break;
					default:System.out.println("\t*****错误的选择，请重新选择*****\n\n");driver_manage();break;
					}	
				}
				else System.out.println("*****查无该司机号对应的司机!*****\n");
				
				break;
			case '2':
				break;
			default:System.out.println("\t*****错误的选择，请重新选择*****\n\n");driver_manage();break;
			}	
		}
		catch (Exception e){
			System.out.println("数据库操作异常！");
			e.printStackTrace();
		}
	}
	
	//输出当前数据库中表Car中的所有车辆信息
	public void car_imformation()
	{
		Manager m=new Manager();
		Connection conn=m.connect();
		try{
			Statement st=conn.createStatement();
			String sql=new String("select * from car");
			ResultSet rs=st.executeQuery(sql);
			System.out.print("\n车牌号\t\t车型\t\t颜色\t购入日期\t\t车况\t出租与否\n");
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
			System.out.println("数据库操作异常！");
			e.printStackTrace();
		}
	}
	
	//向表Car中增加新的车辆的数据，即插入一行新数据
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
			System.out.print("\n请输入车型（例如长安-奔奔、北京-现代）:");
			cartype=sc.next();
			System.out.print("请输入车身颜色（例如黄绿、蓝白）:");
			color=sc.next();
			System.out.print("请输入购入日期（例如2015-07-08）:");
			buydate=sc.next();
			System.out.print("请输入车况（例如良好、一般、维修）：");
			carstate=sc.next();
			String sql_2=new String("insert into car(carid,cartype,color,buydate,carstate) values ("+id+",'"+cartype+"','"+color+"','"+buydate+"','"+carstate+"');");
			st.executeUpdate(sql_2);
			//插入完成
			System.out.println("\n*****插入成功*****\n新的出租车信息：\n"+id+","+cartype+","+color+","+buydate+","+carstate);
		}
		catch (Exception e){
			System.out.println("数据库操作异常！");
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
				System.out.println("\n\t*****司机信息(司机号为："+did+")*****");
				System.out.println("\t司机号：\t\t"+rs.getString(1));
				System.out.println("\t身份证号：\t"+rs.getString(3));
				System.out.println("\t驾照号：\t\t"+rs.getString(4));
				System.out.println("\t姓名：\t\t"+rs.getString(5));
				System.out.println("\t性别：\t\t"+rs.getString(6));
				System.out.println("\t发证时间：\t"+rs.getString(7));
				System.out.println("\t驾龄：\t\t"+rs.getString(8));
				System.out.println("\t出车许可：\t"+rs.getString(9));
				System.out.println("\t车牌号：\t\t"+rs.getString(2));
				System.out.println("\t车型：\t\t"+rs.getString(10));
				System.out.println("\t颜色：\t\t"+rs.getString(11));
				System.out.println("\t车况：\t\t"+rs.getString(12));
		}
		catch (Exception e){
			System.out.println("数据库操作异常！");
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
			System.out.print("\n订单号\t\t司机号\t\t车牌号\t\t开始日期\t\t结束日期\t\t租金(元)\t保险（元）\t\n");
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
			System.out.println("数据库操作异常！");
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
		System.out.println("\n\t*****司机出车界面(司机号为："+did+")*****");
		
		Statement st=conn.createStatement();
		ResultSet rs;
		String sql="select isallow from driver where did="+did;
		rs=st.executeQuery(sql);
		rs.next();
		String isallow=rs.getString(1);
		
		if(isallow.equals("1"))
		{
		System.out.println("\t1.确认出车");
		System.out.println("\t2.返回");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t***错误的输入长度，请重新选择***\n\n");
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
//		System.out.println("测试"+sql);
		st.executeUpdate(sql);
		System.out.println("*****出车成功，已登入系统内的出车表！*****\n");
		break;
	case '2':
		break;
	default:System.out.println("\t***错误的选择，请重新选择***\n\n");System_window();break;
	}
		}
		else System.out.println("\n\n\t*****无出车权限！******\n");
		}
	catch (Exception e){
		e.printStackTrace();
	}
		
	}
	
	//司机向系统提交违规信息
	public void up_illegal(String did)
	{
		Driver d=new Driver();
		Connection conn=d.connect();
		try{
		Scanner sc=new Scanner(System.in);
		String input=new String();
		char choice;
		System.out.println("\n\t*****上交违规信息界面(司机号为："+did+")*****");
		System.out.println("\t1.上交违规信息");
		System.out.println("\t2.返回");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t***错误的输入长度，请重新选择***\n\n");
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
		String carid=rs.getString(1);//找到did对应的carid
		
		sql="select max(illegalid) from illegalnotes";
		rs=st.executeQuery(sql);
		rs.next();
		String illegalid=rs.getString(1);
		int ilid=Integer.parseInt(illegalid);
		ilid+=1;
		illegalid=Integer.toString(ilid);//本次违规单单号	
		
		System.out.println("输入罚分：");
		String punishment=sc.next();
		
		System.out.println("输入违规日期（yyyy-mm-dd）：");
		String illegaldate=sc.next();
		
		System.out.println("输入发生地点：");
		String address=sc.next();
		
		System.out.println("输入违规详情：");
		String detail=sc.next();
		
		sql=new String("insert into illegalnotes values("+illegalid+","+did+","+carid+","+punishment+",'"+illegaldate+"','"+
				address+"','"+detail+"')");
		
//		System.out.println("测试"+sql);
		st.executeUpdate(sql);
		System.out.println("*****上交成功，违规信息已登入系统内的违规表！*****\n");
		break;
	case '2':
		break;
	default:System.out.println("\t***错误的选择，请重新选择***\n\n");System_window();break;
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
		System.out.println("\n\t*****司机界面(司机号为："+did+")*****");
		System.out.println("\t1.查看自身信息");
		System.out.println("\t2.查看合同信息");
		System.out.println("\t3.出车");
		System.out.println("\t4.提交违规信息");
		System.out.println("\t5.退出");
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t***错误的输入长度，请重新选择***\n\n");
		input=sc.next();
		choice=input.charAt(0);
	}
	switch(choice)
	{
	case '1':driver_imformation(did);manage(did);break;
	case '2':driver_rentimformation(did);manage(did);break;
	case '3':up_chuche(did);manage(did);break;
	case '4':up_illegal(did);manage(did);break;
	default:System.out.println("\t***错误的选择，请重新选择***\n\n");System_window();break;
	}
	}
}

public class TaxiMangeSystem {
	public static final String url = "jdbc:mysql://localhost:3306/taximanage?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8&amp";
	public static final String name = "com.mysql.cj.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "jswang";
	//用于建立数据库的连接
	public Connection connect()
	{
		try {
			Connection con=null;
			Class.forName(name);//指定连接类型1
			con = DriverManager.getConnection(url, user, password);//获取连接
			//pst = conn.prepareStatement(sql);//准备执行语句
			//System.out.println("Connect succeed!");
			return con;
		} catch (Exception e) {
			//System.out.println("Connect failed!");
			e.printStackTrace();
			return null;
		}
	}
	//用于关闭数据库的连接
	public void close(Connection c)
	{
		try {
			c.close();
			System.out.println("Connect closed!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//调用子类Manager的manage()方法进行管理操作
	public void manage()
	{
		//System.out.println("管理员界面");
		Manager m=new Manager();
		m.manage();
	}
	//调用子类Driver的一系列方法进行操作
	public void driver(String did)
	{
		//System.out.println("司机界面");
		Driver d=new Driver();
		d.manage(did);
	}
	//用于区分使用该系统的用户，管理员或司机
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
			System.out.print("请输入管理员账号：");
			in=sc.next();
			String sql=new String("select account,pwd from manager" );
			ResultSet rs = st.executeQuery(sql);
		/*	while(rs.next()){
				System.out.println(rs.getString(1)+rs.getString(2));
			}*/
			while(rs.next()){
				if(in.equals(rs.getString(1)))
				{
					System.out.print("请输入密码：");
					in=sc.next();
					if(in.equals(rs.getString(2)))
					{
						flag=true;
						manage();
					}
				}
			
			}
			if(!flag)System.out.println("\t*****登陆失败--账号不存在或密码错误！*****");
		}
		
		else if(distinguish==2)
		{
			System.out.print("请输入司机号：");
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
					System.out.print("请输入身份证号：");
					in=sc.next();
					if(in.equals(rs.getString(2)))
					{
						flag=true;
						driver(did);
					}
				}
			
			}
			if(!flag)System.out.println("\t*****登陆失败--司机号不存在或身份证号错误！*****");
		}
		}
		catch (Exception e) {
			System.out.println("数据库操作异常！");
			e.printStackTrace();
	}
	//本系统的主要入口
	}
	public void System_window()
	{
		System.out.println("\n\t选择用户身份或退出：\n\t1.管理员\n\t2.司机\n\t3.退出");
		String input=new String();
		char choice;
		Scanner sc=new Scanner(System.in);
		input=sc.next();
		choice=input.charAt(0);
		while((input.length()>1||input.length()<=0))
	{
		System.out.println("\t*****错误的输入长度，请重新选择*****\n\n");
		System.out.println("\t选择用户身份或退出：\n\t1.管理员\n\t2.司机\n\t3.退出");
		input=sc.next();
		choice=input.charAt(0);
	}
	switch(choice)
	{
	case '1':login(1);System_window();break;
	case '2':login(2);System_window();break;
	case '3':break;
	default:System.out.println("\t*****错误的选择，请重新选择*****\n\n");System_window();break;
	}
	}
	//主函数，整个程序运行的开始与结束
	public static void main(String args[])
	{
		TaxiMangeSystem taxi=new TaxiMangeSystem();
		taxi.System_window();
		System.out.println("运行结束！");
		
	}
}
