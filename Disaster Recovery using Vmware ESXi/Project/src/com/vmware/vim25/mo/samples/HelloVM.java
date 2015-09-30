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

package com.vmware.vim25.mo.samples;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.samples.alarm.CreateVmAlarm;
import com.vmware.vim25.mo.samples.vm.PingVM;
import com.vmware.vim25.mo.samples.vm.VMSnapshot;

public class HelloVM 
{
	public static void main(String[] args) throws Exception
	{
		long start = System.currentTimeMillis();
		URL url = new URL("https://130.65.132.202/sdk");
		ServiceInstance si = new ServiceInstance(url, "root", "12!@qwQW", true);
		long end = System.currentTimeMillis();
		System.out.println("time taken:" + (end-start));
		Folder rootFolder = si.getRootFolder();
		String name = rootFolder.getName();
		System.out.println("root:" + name);
		ManagedEntity[] mes = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
		if(mes==null || mes.length ==0)
		{
			return;
		}
		
		VirtualMachine vm = (VirtualMachine) mes[0]; 
		vm.getResourcePool();
		System.out.println("\nVirtual Machine---");
		System.out.println("Hello " + vm.getName());
		
		/*Virtual Machine Config Summary */
		VirtualMachineConfigSummary vmcs = new VirtualMachineConfigSummary();
		System.out.println("\nVirtual Machine Config Summary---");
		System.out.println("Number of CPUs: "+ vmcs.getNumCpu());
		
		/* virtual machine config info */
		VirtualMachineConfigInfo vminfo = vm.getConfig();
		System.out.println("\nVirtual Machine Config info---");
		System.out.println("GuestOS: " + vminfo.getGuestFullName());
		System.out.println("Cpu Allocation: " + vminfo.cpuAllocation.getLimit());
		System.out.println("Cpu hot enabled: " + vminfo.cpuHotAddEnabled);
		
		/* virtual machine capability */
		VirtualMachineCapability vmc = vm.getCapability();
		System.out.println("\nVirtual Machine capability---");
		System.out.println("Multiple snapshot supported: " + vmc.isMultipleSnapshotsSupported());
		
		/* cpu usage */
		VirtualMachineRuntimeInfo vmri = new VirtualMachineRuntimeInfo();
		System.out.println("\nVirtual Machine runtime info---");
		System.out.println("CPU usage: "+ vmri.getMaxCpuUsage());
		System.out.println("Memory usage: "+ vmri.getMaxMemoryUsage());
		
		/* Network */
		Network[] n = vm.getNetworks();
		System.out.println("\nNetwork---");
		System.out.println("Network name: "+ n[0].getName());
		System.out.println("Network ip: "+ n[0].toString());
		
		/* virtual machine summary */
		VirtualMachineSummary vms = vm.getSummary();
		System.out.println("\nVirtual Machine Summary---");
		System.out.println("QuickStats: "+ vms.getQuickStats());
		System.out.println("Virtual Machine runtime: "+ vms.getRuntime());
	
		si.getServerConnection().logout();
		
		CreateVmAlarm createVmAlarm = new CreateVmAlarm();
		Timer timer = new Timer();
		long interval = 10000;
		
		timer.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
		    	  try {
						VMSnapshot vmSnap = new VMSnapshot();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    }
		}, 0, interval);
		
		
		long interval1 = 10000;
		timer.scheduleAtFixedRate(new TimerTask() {

		    @Override
		    public void run() {
		    	  try {
						PingVM pvm = new PingVM();
						pvm.pingHost1();
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (MalformedURLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    }
		}, 0, interval1);
		
		
	}

}