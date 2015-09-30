/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

 * Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

 * Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25.mo.samples.vm;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import com.vmware.vim25.HostVMotionCompatibility;
import com.vmware.vim25.TaskInfo;
import com.vmware.vim25.VirtualMachineMovePriority;
import com.vmware.vim25.VirtualMachinePowerState;
import com.vmware.vim25.mo.ComputeResource;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class MigrateVM
{
  public MigrateVM(String vmName, String hostName) throws Exception
  {
    /*if(args.length!=5)
    {
      System.out.println("Usage: java MigrateVM <url> " +
      "<username> <password> <vmname> <newhost>");
      System.exit(0);
    }*/
/*
    String vmName = args[3];
    String newHostName = args[4];

    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);*/
  
	  ServiceInstance si = new ServiceInstance (
	        new URL("https://130.65.132.200/sdk"), "administrator", "12!@qwQW", true);

	    Folder rootFolder = si.getRootFolder();

    
    VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
        rootFolder).searchManagedEntity(
            "VirtualMachine", vmName);
  
    ManagedEntity[] hosts = new InventoryNavigator(rootFolder).searchManagedEntities(
            new String[][] { {"HostSystem", "name" }, }, true);
  
	HostSystem newHost = (HostSystem) new InventoryNavigator(
        rootFolder).searchManagedEntity(
            "HostSystem", hostName);
    ComputeResource cr = (ComputeResource) newHost.getParent();
    
    String[] checks = new String[] {"cpu", "software"};
    
    HostVMotionCompatibility[] vmcs =
      si.queryVMotionCompatibility(vm, new HostSystem[] 
         {newHost},checks );

    String[] comps = vmcs[0].getCompatibility();
    if(checks.length != comps.length)
    {
      System.out.println("CPU/software NOT compatible. Exit.");
      si.getServerConnection().logout();
      return;
    }
    
    System.out.println("The VM is "+vm.getRuntime().getPowerState());
    
    Task liveMigration = null;
    Task coldMigration = null;
    
    Task task = vm.migrateVM_Task(cr.getResourcePool(), newHost,
        VirtualMachineMovePriority.highPriority, 
        VirtualMachinePowerState.poweredOn);
  
    if (vm.getRuntime().getPowerState() == VirtualMachinePowerState.poweredOn) {
	    liveMigration = vm.migrateVM_Task(cr.getResourcePool(), newHost,
	        VirtualMachineMovePriority.highPriority, 
	        VirtualMachinePowerState.poweredOn);
	    System.out.println("Lets do live migration");
	    }
	    else {
	    coldMigration = vm.migrateVM_Task(cr.getResourcePool(), newHost,
	            VirtualMachineMovePriority.highPriority, 
	            VirtualMachinePowerState.poweredOff);
	    System.out.println("Lets do cold migration");
	    }
	    if((liveMigration != null) && (liveMigration.waitForTask()==Task.SUCCESS))
	    {
	      System.out.println("VMotioned!");
	      System.out.println("The VM is live migrated");
	    }
	    else if((coldMigration != null) && (coldMigration.waitForTask()==Task.SUCCESS))
	    {
	      System.out.println("The VM is cold migrated");
	    }
	    else
	    {
	      System.out.println("Migration failed!");
	    }
	    
    /*if(task.waitForMe()==Task.SUCCESS)
    {
      System.out.println("VMotioned!");
    }
    else
    {
      System.out.println("VMotion failed!");
      TaskInfo info = task.getTaskInfo();
      System.out.println(info.getError().getFault());
    }*/
    si.getServerConnection().logout();
  }
}
