// This file was generated by Mendix Studio Pro.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package pushnotifications.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;
import pushnotifications.proxies.Message;
import java.util.ArrayList;
import java.util.List;
import static pushnotifications.proxies.microflows.Microflows.createAndSendMessageToUser;

/**
 * Java action to send a message directly to all devices of a user
 * Parameters: 
 * Device: Android or iOS
 * MessageText: the contents of the message
 * Title: The title of the message
 * Badge: a number that appears on the app icon (iOS)
 * LaunchImage: file name of the launch image (iOS)
 * Sound: name of system sound to play (iOS)
 * 
 */
public class SendMessageToUser extends CustomJavaAction<java.util.List<IMendixObject>>
{
	private IMendixObject __MessageDataParam;
	private pushnotifications.proxies.MessageData MessageDataParam;
	private IMendixObject __UserParam;
	private system.proxies.User UserParam;
	private IMendixObject ContextObject;

	public SendMessageToUser(IContext context, IMendixObject MessageDataParam, IMendixObject UserParam, IMendixObject ContextObject)
	{
		super(context);
		this.__MessageDataParam = MessageDataParam;
		this.__UserParam = UserParam;
		this.ContextObject = ContextObject;
	}

	@java.lang.Override
	public java.util.List<IMendixObject> executeAction() throws Exception
	{
		this.MessageDataParam = __MessageDataParam == null ? null : pushnotifications.proxies.MessageData.initialize(getContext(), __MessageDataParam);

		this.UserParam = __UserParam == null ? null : system.proxies.User.initialize(getContext(), __UserParam);

		// BEGIN USER CODE
		if (ContextObject != null) {
			Long guid = ContextObject.getId().toLong();
			MessageDataParam.setIdentifier(guid);
		}

		List<Message> messages = createAndSendMessageToUser(getContext(), UserParam, MessageDataParam);
		List<IMendixObject> objects = new ArrayList<>();
		messages.forEach(message -> {
			objects.add(message.getMendixObject());
		});
		return objects;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@java.lang.Override
	public java.lang.String toString()
	{
		return "SendMessageToUser";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
