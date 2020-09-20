package kr.co.tjoeun.jicbangcopy_20200920.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.tjoeun.jicbangcopy_20200920.R
import kr.co.tjoeun.jicbangcopy_20200920.datas.Room

class RoomAdapter(
    val mContext:Context,
    val resID:Int,
    val mList:ArrayList<Room>) : ArrayAdapter<Room>(mContext, resID, mList) {

    val inf = LayoutInflater.from(mContext)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if (tempRow == null) {
            tempRow = inf.inflate(R.layout.room_item_list, null)
        }

        val row = tempRow!!

        val priceTxt = row.findViewById<TextView>(R.id.priceTxt)
        val addressAndFloorTxt = row.findViewById<TextView>(R.id.addressAndFloorTxt)
        val descriptionTxt = row.findViewById<TextView>(R.id.descriptionTxt)


        var roomData = mList[position]

        descriptionTxt.text = roomData.description

        addressAndFloorTxt.text = "${roomData.address}, ${roomData.getFormattedFloor()}"

        priceTxt.text = "${roomData.price}"

        priceTxt.text = roomData.getFormattedPrice()

        return row
    }
}