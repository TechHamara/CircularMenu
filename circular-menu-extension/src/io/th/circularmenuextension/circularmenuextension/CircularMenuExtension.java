package io.th.circularmenuextension.circularmenuextension;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.EventDispatcher;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;
import android.view.View; 
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.EventDispatcher;

@DesignerComponent(
	version = 7,
	versionName = "1.0",
	description = "Developed by th using Fast.",
	iconName = "icon.png"
)
public class CircularMenuExtension extends AndroidNonvisibleComponent {

    private final Context context;
    private CircularMenu circularMenu;

    public CircularMenuExtension(ComponentContainer container) {
        super(container.$form());
        this.context = container.$context();
    }

    @SimpleFunction(description = "Initialize the Circular Menu inside a Vertical or Horizontal Arrangement.")
public void Initialize(AndroidViewComponent arrangement) {
    if (arrangement == null || arrangement.getView() == null) {
        Toast.makeText(context, "Please provide a valid arrangement!", Toast.LENGTH_SHORT).show();
        return;
    }
    ViewGroup viewGroup = (ViewGroup) arrangement.getView();
    if (circularMenu == null) {
        circularMenu = new CircularMenu(context);
    }

    circularMenu.post(() -> {
        if (circularMenu.getMeasuredWidth() == 0 || circularMenu.getMeasuredHeight() == 0) {
            Toast.makeText(context, "CircularMenu dimensions are not ready!", Toast.LENGTH_SHORT).show();
        } else {
            viewGroup.addView(circularMenu);
        }
    });
}

        // Set Center View
@SimpleFunction(description = "Set a custom center view for the circular menu")
public void SetCenterView(AndroidViewComponent arrangement, AndroidViewComponent centerView) {
    if (arrangement == null || centerView == null) {
        Toast.makeText(context, "Please provide valid arrangement and center view!", Toast.LENGTH_SHORT).show();
        return;
    }

    ViewGroup viewGroup = (ViewGroup) arrangement.getView();
    View centerViewContent = centerView.getView(); // Fetching the actual view for the center

    circularMenu = new CircularMenu(context);
    circularMenu.setCenterView(centerViewContent);
    viewGroup.addView(circularMenu);
}
    

    @SimpleProperty(description = "Set the background color of the Circular Menu.")
    public void BackgroundColor(int color) {
        if (circularMenu != null) {
            circularMenu.setBackgroundColor(color);
        }
    }
    
    @SimpleProperty(description = "Set the Pressed color of the Circular Menu.")
    public void PressedColor(int color) {
        if (circularMenu != null) {
            circularMenu.setPressedColor(color);
        }
    }
    
    @SimpleProperty(description = "Set the Line width of the Circular Menu.")
    public void LineWidth(int width) {
        if (circularMenu != null) {
            circularMenu.setLineWidth(width);
        }
    }
    
    @SimpleProperty(description = "Set the Radius Line Width of the Circular Menu.")
    public void RadiusLineWidth(int width) {
        if (circularMenu != null) {
            circularMenu.setRadiusLineWidth(width);
        }
    }

    @SimpleProperty(description = "Set the radius of the Circular Menu.")
    public void Radius(float radius) {
        if (circularMenu != null) {
            circularMenu.setRadius(radius);
        }
    }

    @SimpleProperty(description = "Set the inner radius of the Circular Menu.")
    public void InnerRadius(float innerRadius) {
        if (circularMenu != null) {
            circularMenu.setInnerRadius(innerRadius);
        }
    }

    @SimpleProperty(description = "Set the start angle of the Circular Menu.")
    public void StartAngle(int startAngle) {
        if (circularMenu != null) {
            circularMenu.setStartAngle(startAngle);
        }
    }

    @SimpleProperty(description = "Set the item color of the Circular Menu.")
    public void ItemColor(int color) {
        if (circularMenu != null) {
            circularMenu.setItemColor(color);
        }
    }

    @SimpleProperty(description = "Set the number of items in the Circular Menu.")
    public void ItemCount(int count) {
        if (circularMenu != null) {
            circularMenu.setItemCount(count);
        }
    }
    
        // Getters
    @SimpleFunction(description = "Get the color of a pressed item")
    public int GetPressedColor() {
        if (circularMenu != null) {
            return circularMenu.getPressedColor();
        }
        return 0; // Default color or error value
    }

    @SimpleFunction(description = "Get the starting angle of the circular menu")
    public float GetStartAngle() {
        if (circularMenu != null) {
            return circularMenu.getStartAngle();
        }
        return 0.0f;
    }

    @SimpleFunction(description = "Get the color of a menu item")
    public int GetItemColor() {
        if (circularMenu != null) {
            return circularMenu.getItemColor();
        }
        return 0;
    }

    @SimpleFunction(description = "Get the background color of the circular menu")
    public int GetBackgroundColor() {
        if (circularMenu != null) {
            return circularMenu.getBackgroundColor();
        }
        return 0;
    }

    @SimpleFunction(description = "Get the line width of the radius")
    public float GetRadiusLineWidth() {
        if (circularMenu != null) {
            return circularMenu.getRadiusLineWidth();
        }
        return 0.0f;
    }

    @SimpleFunction(description = "Get the line width of the circular menu")
    public float GetLineWidth() {
        if (circularMenu != null) {
            return circularMenu.getLineWidth();
        }
        return 0.0f;
    }

    @SimpleFunction(description = "Get the inner radius of the circular menu")
    public float GetInnerRadius() {
        if (circularMenu != null) {
            return circularMenu.getInnerRadius();
        }
        return 0.0f;
    }

    @SimpleFunction(description = "Get the radius of the circular menu")
    public float GetRadius() {
        if (circularMenu != null) {
            return circularMenu.getRadius();
        }
        return 0.0f;
    }

    @SimpleFunction(description = "Get the count of items in the circular menu")
    public int GetItemCount() {
        if (circularMenu != null) {
            return circularMenu.getItemCount();
        }
        return 0;
    }

    @SimpleEvent(description = "Triggered when an item in the Circular Menu is clicked.")
    public void ItemClicked(int index) {
        EventDispatcher.dispatchEvent(this, "ItemClicked", index);
    }

    @SimpleEvent(description = "Triggered when the center item of the Circular Menu is clicked.")
    public void CenterClicked() {
        EventDispatcher.dispatchEvent(this, "CenterClicked");
    }

    private final CircularMenu.OnItemClickListener onItemClickListener = new CircularMenu.OnItemClickListener() {
        @Override
        public void onItemClick(int index) {
            ItemClicked(index);
        }

        @Override
        public void onCenterClick() {
            CenterClicked();
        }
    };

    @SimpleFunction(description = "Attach click listeners to handle item clicks.")
    public void SetClickListener() {
        if (circularMenu != null) {
            circularMenu.setOnItemClickListener(onItemClickListener);
        }
    }


}
