/**
 * 
 */
package net.will.selftools.delvsssvn;

/**
 * @author Will
 * @version 2011-1-11
 *
 */
public class DeleteVssOrSvnFilesMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeleteVssOrSvnFilesTool tool = DeleteVssOrSvnFilesTool.getInstance();
		
		try {
//			if ( args.length != 1 ) {
//				showUsage();
//				return;
//			}
			String foldPath = "D:\\WorkspaceBOSS\\willcommon";
			tool.executeDeletingOper(foldPath);
//			tool.executeDeletingOper("L:\\WorkspaceEOMS\\MobileEOMS\\KmBranches\\cn_mobile");
//			tool.executeDeletingOper(args[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void showUsage() {
		System.out.println(DeleteVssOrSvnFilesMain.class.getName() + " PathToConvert");
	}

}
