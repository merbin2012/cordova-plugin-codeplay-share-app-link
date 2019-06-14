package cordova.plugin.codeplay.share.app.link;

import android.content.Context;
import android.support.v4.app.ShareCompat;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class codeplayshareapplink extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		
            String shareTitle = args.getString(0);
            String shareText = args.getString(1);
		
		
        if (action.equals("shareWithContact")) {

            Context testParameter = (cordova.getActivity()).getBaseContext();


            ShareCompat.IntentBuilder
                    .from(cordova.getActivity())
                    .setText(shareText)
                    .setType("text/plain")
                    .setChooserTitle(shareTitle)
                    .startChooser();
			
			callbackContext.success("Success");
			
            return true;
        }
		
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
