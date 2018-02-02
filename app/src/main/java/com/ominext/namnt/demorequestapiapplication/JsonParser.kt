package com.ominext.namnt.demorequestapiapplication

import java.nio.file.Files.exists
import org.json.JSONObject
import org.json.JSONArray
import java.io.BufferedWriter
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.net.URL


/**
 * Created by nam on 02/02/2018.
 */
class JsonParser {
/*//    private var link: String? = null
   private var pageToken = ""
    private var data: String? = ""

    private val s = arrayOf("coffee", "cafe", "quán+cà+phê", "quán+cafe", "quán+coffee", "café", "cà+phê") // search list

//    fun Parser(link: String){
//        this.link = link
//    }

    @Throws(Exception::class)
    fun parse() {
//        val file = File("D:/KDL/data.txt")
//        createFile(file)
//
//        //
//        val format = "json"
//        val location = "9.179533,105.150190" // location
//        val radius = "49000"
//        val type = ""
//        var nameSearch: String
//        val key = "AIzaSyAjCxDFbqC9uy11X5SKpmLzVqFXy6KKJP4"
//        //
//
      var prevObject: JSONObject
//        for (i in s.indices) {
//            nameSearch = s[i]
//            link = "https://maps.googleapis.com/maps/api/place/nearbysearch/" + format + "?" +
//                    "type" + "&" +
//                    "location=" + location + "&" +
//                    "radius=" + radius + "&" +
//                    "name=" + nameSearch + "&" +
//                    "key=" + key

            data =
            var jsonObjectRoot = JSONObject(data)

            do {
                Thread.sleep(2000)
                val jsonArrayResults = jsonObjectRoot.getJSONArray("results")

                for (j in 0 until jsonArrayResults.length()) {

                    val jsonObjectResult = jsonArrayResults.getJSONObject(j)

                    val name = jsonObjectResult.getString("name")
                    val address = jsonObjectResult.getString("vicinity")

                    val jsonObjectGeometry = jsonObjectResult.getJSONObject("geometry")
                    val jsonObjectLocation = jsonObjectGeometry.getJSONObject("location")

                    val lat = jsonObjectLocation.getDouble("lat")
                    val lng = jsonObjectLocation.getDouble("lng")

//                    val bufferedWriter = BufferedWriter(OutputStreamWriter(FileOutputStream("D:/KDL/data.txt", true)))
//                    val dataLine = name + "_" + address + "_" + "_" + lat + "_" + lng
//                    bufferedWriter.write(String(dataLine.toByteArray(charset("ISO-8859-1")), "UTF-8"))
//                    bufferedWriter.newLine()
//                    bufferedWriter.close()
//                    println(String(dataLine.toByteArray(charset("ISO-8859-1")), "UTF-8"))
                }


                prevObject = jsonObjectRoot
                if (jsonObjectRoot.has("next_page_token")) {
                    pageToken = jsonObjectRoot.getString("next_page_token")
                    data = getData(link + "&" + "pagetoken=" + pageToken)
                    println(link + "&" + "pagetoken=" + pageToken)
                    jsonObjectRoot = JSONObject(data)
                }


            } while (prevObject.has("next_page_token"))

        }

    }

    @Throws(Exception::class)
    private fun createFile(file: File) {
        if (file.exists()) {
            return
        }
        val parent = file.getParentFile()
        parent.mkdirs()
        file.createNewFile()
    }

    private fun getData(link: String): String? {
        try {
            //            Thread.sleep(1000);
            val url = URL(link)
            val connection = url.openConnection()
            val stream = connection.getInputStream()
            val builder = StringBuilder()
            var c = stream.read()
            while (c != -1) {
                builder.append(c.toChar())
                c = stream.read()
            }
            //            System.out.println(builder.toString());
            return builder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }*/
}