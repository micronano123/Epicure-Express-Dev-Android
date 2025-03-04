package za.co.micronano.epicureexpress;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class represents a menu item and implements Parcelable to pass data between activities
 * @author takatsomolekane
 */
public class MenuItem implements Parcelable {
    private String name;
    private String description;
    private double price;
    private int imageResId;
    private int quantity;

    public MenuItem(String name, String description, double price, int imageResId){
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResId = imageResId;
        this.quantity = 0;
    }

    protected MenuItem(Parcel in) {
        name = in.readString();
        description = in.readString();
        price = in.readDouble();
        imageResId = in.readInt();
        quantity = in.readInt();
    }

    public static final Creator<MenuItem> CREATOR = new Creator<MenuItem>() {
        @Override
        public MenuItem createFromParcel(Parcel source) {
            return new MenuItem(source);
        }

        @Override
        public MenuItem[] newArray(int size) {
            return new MenuItem[size];
        }
    };

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(name);
        dest.writeString(description);
        dest.writeDouble(price);
        dest.writeInt(imageResId);
        dest.writeInt(quantity);
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}
