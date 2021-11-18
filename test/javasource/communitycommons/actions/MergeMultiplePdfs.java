// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package communitycommons.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import com.mendix.webui.CustomJavaAction;
import communitycommons.Misc;

/**
 * Restricted to 10 files at once for Mendix Cloud v4 compatibility. If you need to merge more than 10 files at once merge recursively instead or change the MergeMultiplePdfs_MaxAtOnce constant.
 */
public class MergeMultiplePdfs extends CustomJavaAction<java.lang.Boolean>
{
	private java.util.List<IMendixObject> __FilesToMerge;
	private java.util.List<system.proxies.FileDocument> FilesToMerge;
	private IMendixObject __MergedDocument;
	private system.proxies.FileDocument MergedDocument;

	public MergeMultiplePdfs(IContext context, java.util.List<IMendixObject> FilesToMerge, IMendixObject MergedDocument)
	{
		super(context);
		this.__FilesToMerge = FilesToMerge;
		this.__MergedDocument = MergedDocument;
	}

	@java.lang.Override
	public java.lang.Boolean executeAction() throws Exception
	{
		this.FilesToMerge = new java.util.ArrayList<system.proxies.FileDocument>();
		if (__FilesToMerge != null)
			for (IMendixObject __FilesToMergeElement : __FilesToMerge)
				this.FilesToMerge.add(system.proxies.FileDocument.initialize(getContext(), __FilesToMergeElement));

		this.MergedDocument = __MergedDocument == null ? null : system.proxies.FileDocument.initialize(getContext(), __MergedDocument);

		// BEGIN USER CODE
		return Misc.mergePDF(this.getContext(), this.FilesToMerge, this.MergedDocument.getMendixObject());
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "MergeMultiplePdfs";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
