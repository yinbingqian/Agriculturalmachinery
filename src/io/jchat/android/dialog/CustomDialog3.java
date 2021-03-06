package io.jchat.android.dialog;

import com.lnpdit.agriculturalmachinery.R;

import android.app.Activity;
import android.app.Dialog;  
import android.content.Context;  
import android.content.DialogInterface;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;  
import android.view.View;  
import android.view.ViewGroup.LayoutParams;  
import android.widget.Button;  
import android.widget.LinearLayout;  
import android.widget.TextView;  
    
  
public class CustomDialog3 extends Dialog {  
  
    public CustomDialog3(Context context) {  
//        super(context);  
        super(context, android.R.style.Theme);
        setOwnerActivity((Activity)context);
    }  
  
    public CustomDialog3(Context context, int theme) {  
        super(context, theme);  
//        this.setContentView(R.layout.dialog_yindao);
//    	DisplayMetrics dm = new DisplayMetrics();
//        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
//        android.view.WindowManager.LayoutParams p = this.getWindow().getAttributes();  //获取对话框当前的参数值
//        p.width =  dm.widthPixels;   //高度设置为屏幕
//        p.height = dm.heightPixels;    //宽度设置为全屏
//        p.gravity = Gravity.CENTER;
//        this.getWindow().setAttributes(p);     //设置生效
    }  
  
    public static class Builder {  
        private Context context;  
        private String title;  
        private String message;  
        private String positiveButtonText;  
        private String negativeButtonText;  
        private View contentView;  
        private DialogInterface.OnClickListener positiveButtonClickListener;  
        private DialogInterface.OnClickListener negativeButtonClickListener;  
  
        public Builder(Context context) {  
            this.context = context;  
        }  
  
        public Builder setMessage(String message) {  
            this.message = message;  
            return this;  
        }  
  
        /** 
         * Set the Dialog message from resource 
         *  
         * @param title 
         * @return 
         */  
        public Builder setMessage(int message) {  
            this.message = (String) context.getText(message);  
            return this;  
        }  
  
        /** 
         * Set the Dialog title from resource 
         *  
         * @param title 
         * @return 
         */  
        public Builder setTitle(int title) {  
            this.title = (String) context.getText(title);  
            return this;  
        }  
  
        /** 
         * Set the Dialog title from String 
         *  
         * @param title 
         * @return 
         */  
  
        public Builder setTitle(String title) {  
            this.title = title;  
            return this;  
        }  
  
        public Builder setContentView(View v) {  
            this.contentView = v;  
            return this;  
        }  
  
        /** 
         * Set the positive button resource and it's listener 
         *  
         * @param positiveButtonText 
         * @return 
         */  
        public Builder setPositiveButton(int positiveButtonText,  
                DialogInterface.OnClickListener listener) {  
            this.positiveButtonText = (String) context  
                    .getText(positiveButtonText);  
            this.positiveButtonClickListener = listener;  
            return this;  
        }  
  
        public Builder setPositiveButton(String positiveButtonText,  
                DialogInterface.OnClickListener listener) {  
            this.positiveButtonText = positiveButtonText;  
            this.positiveButtonClickListener = listener;  
            return this;  
        }  
  
        public Builder setNegativeButton(int negativeButtonText,  
                DialogInterface.OnClickListener listener) {  
            this.negativeButtonText = (String) context  
                    .getText(negativeButtonText);  
            this.negativeButtonClickListener = listener;  
            return this;  
        }  
  
        public Builder setNegativeButton(String negativeButtonText,  
                DialogInterface.OnClickListener listener) {  
            this.negativeButtonText = negativeButtonText;  
            this.negativeButtonClickListener = listener;  
            return this;  
        }  
  
        public CustomDialog create() {  
            LayoutInflater inflater = (LayoutInflater) context  
                    .getSystemService(context.LAYOUT_INFLATER_SERVICE);  
            // instantiate the dialog with the custom Theme  
            final CustomDialog dialog = new CustomDialog(context,R.style.Dialog);  
            View layout = inflater.inflate(R.layout.dialog_yindao, null);  
            dialog.addContentView(layout, new LayoutParams(  
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));  
            
            // set the dialog title  
            ((TextView) layout.findViewById(R.id.title)).setText(title);  
            ((TextView) layout.findViewById(R.id.positiveButton)).setText(positiveButtonText);
            // set the confirm button  
            if (positiveButtonText != null) {  
                  
                if (positiveButtonClickListener != null) {  
                    ((TextView) layout.findViewById(R.id.positiveButton))  
                            .setOnClickListener(new View.OnClickListener() {  
                                public void onClick(View v) {  
                                    positiveButtonClickListener.onClick(dialog,  
                                            DialogInterface.BUTTON_POSITIVE);  
                                }  
                            });  
                }  
            } else {  
                // if no confirm button just set the visibility to GONE  
                layout.findViewById(R.id.positiveButton).setVisibility(  
                        View.GONE);  
            }  
            // set the cancel button 
            
            if (negativeButtonText != null) {  
            	((TextView) layout.findViewById(R.id.negativeButton))  
                .setText(negativeButtonText); 
                if (negativeButtonClickListener != null) {  
                    ((TextView) layout.findViewById(R.id.negativeButton))  
                            .setOnClickListener(new View.OnClickListener() {  
                                public void onClick(View v) {  
                                    negativeButtonClickListener.onClick(dialog,  
                                            DialogInterface.BUTTON_NEGATIVE);  
                                }  
                            });  
                }  
            } else {  
                // if no confirm button just set the visibility to GONE  
//                layout.findViewById(R.id.negativeButton).setVisibility(  
//                        View.GONE);  
            }  
            
            // set the content message  
            if (message != null) {  
                ((TextView) layout.findViewById(R.id.message)).setText(message);  
            } else if (contentView != null) {  
                // if no message set  
                // add the contentView to the dialog body  
                ((LinearLayout) layout.findViewById(R.id.content))  
                        .removeAllViews();  
                ((LinearLayout) layout.findViewById(R.id.content))  
                        .addView(contentView, new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));  
            }  
            dialog.setContentView(layout);  
            return dialog;  
        }  
    }  
}  
