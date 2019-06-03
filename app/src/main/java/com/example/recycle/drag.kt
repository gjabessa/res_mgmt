package com.example.recycle

import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_drag.*

class drag : AppCompatActivity() {
    lateinit var imageView1: ImageView
    lateinit var imageView2: ImageView
    lateinit var imageView3: ImageView
    lateinit var imageView4: ImageView
    lateinit var imageView5: ImageView
    lateinit var imageView6: ImageView
    lateinit var imageView7: ImageView
    lateinit var imageView8: ImageView
    lateinit var imageView9: ImageView
    lateinit var imageView10: ImageView
    lateinit var imageView11: ImageView
    lateinit var imageView12: ImageView

    lateinit var imagev1: ImageView
    lateinit var imagev2:ImageView
    lateinit var imagev3: ImageView
    lateinit var imagev4: ImageView
    lateinit var imagev5: ImageView
    lateinit var imagev6: ImageView
    lateinit var imagev7: ImageView
    lateinit var imagev8: ImageView
    lateinit var imagev9: ImageView
    lateinit var imagev10: ImageView
    lateinit var imagev11: ImageView
    lateinit var imagev12: ImageView

    lateinit var variable: ImageView;
    lateinit var imgv: ImageView;

    lateinit var linearLayou: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag)


        linearLayou = ddd

        imageView1 = image1
        imageView2 = image2
        imageView3 = image3
        imageView4 = image4
        imageView5 = image5
        imageView6 = image6
        imageView7 = image7
        imageView8 = image8
        imageView9 = image9
        imageView10 = image10
        imageView11 = image11
        imageView12 = image12

        imagev1 = View1
        imagev2 = View2
        imagev3 = View3
        imagev4 = View4
        imagev5 = View5
        imagev6 = View6
        imagev7 = View7
        imagev8 = View8
        imagev9 = View9
        imagev10 = View10
        imagev11 = View11
        imagev12 = View12

        imagev1.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev2.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev3.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev4.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev5.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev6.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev7.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev8.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev9.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev10.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev11.setColorFilter(Color.parseColor("#D2FCFB"))
        imagev12.setColorFilter(Color.parseColor("#D2FCFB"))


        imageView1.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev1;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView1)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }
        imageView2.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev2;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView2)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }

        imageView3.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev3;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView3)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }

        imageView4.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev4;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView4)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }
        imageView5.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev5;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView5)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }
        imageView6.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev6;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView6)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }

        imageView7.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev7;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView7)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }

        imageView8.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev8;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView8)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }

        imageView9.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev9;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView9)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }

        imageView10.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev10;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView10)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }

        imageView11.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev11;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)

            // Instantiates the drag shadow builder.
            val myShadow = MyDragShadowBuilder(imageView11)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
                myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }

        imageView12.setOnLongClickListener { v: View ->
            // Create a new ClipData.
            // This is done in two steps to provide clarity. The convenience method
            // ClipData.newPlainText() can create a plain text ClipData in one step.
            variable = imagev12;
            // Create a new ClipData.Item from the ImageView object's tag
            val item = ClipData.Item(v.tag as? CharSequence)

            // Create a new ClipData using the tag as a label, the plain text MIME type, and
            // the already-created item. This will create a new ClipDescription object within the
            // ClipData, and set its MIME type entry to "text/plain"
            val dragData = ClipData(
                v.tag as? CharSequence,
                arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN),
                item)
            // Instantiates the drag shadow builder.

            //val myShadow = MyDragShadowBuilder(imageView12)
            val myShadow = View.DragShadowBuilder(imageView12)

            // Starts the drag
            v.startDrag(
                dragData,   // the data to be dragged
               myShadow,   // the drag shadow builder
                null,       // no need to use local data
                0           // flags (not currently used, set to 0)
            )
        }

// Sets the drag event listener for the View
        linearLayou.setOnDragListener(dragListen)

    }

    private class MyDragShadowBuilder(v: View) : View.DragShadowBuilder(v) {

        private val shadow = v

        // Defines a callback that sends the drag shadow dimensions and touch point back to the
        // system.
        override fun onProvideShadowMetrics(size: Point, touch: Point) {
            // Sets the width of the shadow to half the width of the original View
            val width: Int = view.width

            // Sets the height of the shadow to half the height of the original View
            val height: Int = view.height

            // The drag shadow is a ColorDrawable. This sets its dimensions to be the same as the
            // Canvas that the system will provide. As a result, the drag shadow will fill the
            // Canvas.
            // Sets the size parameter's width and height values. These get back to the system
            // through the size parameter.
            size.set(300, 300)

            // Sets the touch point's position to be in the middle of the drag shadow
            touch.set(150 , 150 )
        }

        // Defines a callback that draws the drag shadow in a Canvas that the system constructs
        // from the dimensions passed in onProvideShadowMetrics().
        override fun onDrawShadow(canvas: Canvas) {
            // Draws the ColorDrawable in the Canvas passed in from the system.
            shadow.draw(canvas)
        }
    }

    private val dragListen = View.OnDragListener { v, event ->

        // Handles each of the expected events
        when (event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                // Determines if this View can accept the dragged data
                if (event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // As an example of what your application might do,
                    // applies a blue color tint to the View to indicate that it can accept
                    // data.
                    //(v as? LinearLayout)?.setBackgroundColor(Color.BLUE)
                    // Invalidate the view to force a redraw in the new tint
                    v.invalidate()

                    // returns true to indicate that the View can accept the dragged data.
                    true
                } else {
                    // Returns false. During the current drag and drop operation, this View will
                    // not receive events again until ACTION_DRAG_ENDED is sent.
                    false
                }
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                // Applies a green tint to the View. Return true; the return value is ignored.
                //(v as? LinearLayout)?.setBackgroundColor(Color.GREEN)

                // Invalidate the view to force a redraw in the new tint
                v.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_LOCATION ->
                // Ignore the event
                true
            DragEvent.ACTION_DRAG_EXITED -> {
                // Re-sets the color tint to blue. Returns true; the return value is ignored.
                //(v as? LinearLayout)?.setBackgroundColor(Color.GREEN-0)

                //imageView1.setColorFilter(Color.BLUE)
                // Invalidate the view to force a redraw in the new tint
                v.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                // Gets the item containing the dragged data
                val item: ClipData.Item = event.clipData.getItemAt(0)

                // Gets the text data from the item.
                val dragData = item.text

                // Displays a message containing the dragged data.
                //Toast.makeText(this, "Dragged data is " + dragData, Toast.LENGTH_LONG).show()

                // Turns off any color tints
                (v as? ImageView)?.clearColorFilter()

                // Invalidates the view to force a redraw
                v.invalidate()

                // Returns true. DragEvent.getResult() will return true.
                true
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                // Turns off any color tinting
                (v as? ImageView)?.clearColorFilter()

                // Invalidates the view to force a redraw
                v.invalidate()

                // Does a getResult(), and displays what happened.
                when(event.result) {
                    true ->
                        variable.clearColorFilter()
                        //Toast.makeText(this, "The drop was handled.", Toast.LENGTH_LONG)
                    else ->
                        Toast.makeText(this, "The drop didn't work.", Toast.LENGTH_LONG).show()
                }

                // returns true; the value is ignored.
                true
            }
            else -> {
                // An unknown action type was received.
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.")
                false
            }
        }
    }

    }

