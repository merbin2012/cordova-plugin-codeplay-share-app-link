package cordova.plugin.codeplay.share.app.link;

import android.content.Intent;


import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class codeplayshareapplink extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        String shareTitle = args.getString(0);
        String shareText = args.getString(1);


        if (action.equals("shareWithContact")) {

            final String appPackageName = cordova.getActivity().getPackageName();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, shareText+" https://play.google.com/store/apps/details?id=" + appPackageName);
            sendIntent.setType("text/plain");
            cordova.getActivity().startActivity(Intent.createChooser(sendIntent, shareTitle));

            return true;
        }

        return false;
    }
}
