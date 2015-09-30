package com.vmware.vim25.mo.samples.vm;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import com.sun.jmx.snmp.Timestamp;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;

public class PingVM {
	
	public void pingHost1() throws Exception{
		
		int aliveHost = 0;
		int aliveVM = 0;
		int deadHost = 0;
		int deadVM = 0;
		
		ServiceInstance si = new ServiceInstance(
		        new URL("https://130.65.132.200/sdk"), "administrator", "12!@qwQW", true);
		
		
		ArrayList<String> liveHosts = new ArrayList<String>();
		
		//ServiceInstance si = new ServiceInstance(new URL("https://130.65.132.210/sdk"), "administrator", "12!@qwQW", true);
		Folder rootFolder = si.getRootFolder();
		
		System.out.println("\nPinging Hosts ----");
		ManagedEntity[] hosts = new InventoryNavigator(rootFolder).searchManagedEntities(
				new String[][] { {"HostSystem", "name" }, }, true);
		ManagedEntity[] VM = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");

		for(int i=0; i<hosts.length; i++) {
			
			System.out.println("host["+i+"]=" + hosts[i].getName());
			Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 3 "+hosts[i].getName());
		    int returnValue = p1.waitFor();
		        //System.out.println(returnVal);
		    boolean reachable = (returnValue==0);
		    if (reachable) {
		    	System.out.println("The host " + hosts[i].getName()+" is reachable");
		    	liveHosts.add(hosts[i].getName());
		        aliveHost = aliveHost+1;
		    }
		    else {
		    	System.out.println("The host " + hosts[i].getName()+" is not reachable, check again");
		    	deadHost = deadHost+1;
		    }
			//System.out.println("Number of VMs in "+hosts[i].getName()+ ": "+VM.length);	
		}
		
		System.out.println("\nPing Virtual Machines----");
		
		for(int j=0; j<VM.length; j++) {	
			VirtualMachine vm = (VirtualMachine)VM[j];
			System.out.println("vm["+j+"]=" + VM[j].getName());
			System.out.println("vm's alarm state for "+VM[j].getName()+" = " + vm.getTriggeredAlarmState());
			
			Process p2 = java.lang.Runtime.getRuntime().exec("ping -c 3 "+vm.getGuest().getIpAddress());
	     	int returnValueVM = p2.waitFor();
	     	boolean reachableVM = (returnValueVM==0);
	     	
	     	if (reachableVM) {
	     		System.out.println("The VM " + VM[j].getName()+" is reachable");
	     	    aliveVM = aliveVM+1;
	     	}
	     	else {
	     		System.out.println("The VM " + VM[j].getName()+" is not reachable, check again");
	  	       	deadVM = deadVM+1;
	  	       	if (VM[j].getTriggeredAlarmState()==null) {
	  	       		System.out.println(VM[j].getName()+" is down. Hence, the VM is being migrated to "+liveHosts.get(0));
	  	       		MigrateVM mvm = new MigrateVM(VM[j].getName(),liveHosts.get(0));
	  	       		
	  	       	}
	     	}
	     	System.out.println(" ");
		}


/*	 
	  String strCommand = "ping -c 3 "+hostip;
	  System.out.println(strCommand);
	  Process myProcess = Runtime.getRuntime().exec(strCommand);
	  
	  int returnval= myProcess.waitFor();
	  boolean reachable =(returnval==0);
			  System.out.println(reachable);

      if(myProcess.exitValue() == 0) {
      	System.out.println("= ping success =");
      } else {
      	System.out.println("= ping failure =");
      }
*/	  
}	
/*	public static void main(String[] args) throws IOException, InterruptedException
	{
		String ip = "130.65.132.202";
		PingVM pvm = new PingVM();
	
		pvm.pingHost1(ip);
		
	}
*/

}
