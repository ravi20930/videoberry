package com.panoslice.videoberry

import GridAdapter
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


class GalleryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_gallery, container, false)

        loadVideos(view)

        return view
    }

    private fun loadVideos(view: View) {
        try {
            val projection = arrayOf(
                MediaStore.Video.Media._ID,
                MediaStore.Video.Media.TITLE,
            )
            val selection = null
            val selectionArgs = null
            val sortOrder = null

            requireActivity().applicationContext.contentResolver.query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                projection,
                selection,
                selectionArgs,
                sortOrder
            )?.use { cursor ->
                while (cursor.moveToNext()) {

                    val file_title: Int = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE)
                    val file_id: Int = cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID)

                    val videoGrid: GridView = view.findViewById(R.id.gridView)

                    val mainAdapter = GridAdapter(requireActivity(), file_id, file_title)
                    videoGrid.adapter = mainAdapter


                }
            }

        } catch (e: Exception) {
            // handler
        }
    }
}