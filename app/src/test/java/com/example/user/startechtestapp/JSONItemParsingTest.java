package com.example.user.startechtestapp;

import com.example.user.startechtestapp.ItemFunctions.Item;
import com.example.user.startechtestapp.ItemFunctions.ItemsJSONParser;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class JSONItemParsingTest {
    @Test
    public void ParsingJSONItemListProducesItemList() throws Exception {
        //arrange
        String jsonList = "[\n" +
                "{\n" +
                "\"title\":\"Moominvalley in November\",\n" +
                "\"author_id\":0,\n" +
                "\"author_name\":\"Tove Jansson\",\n" +
                "\"series_id\":0,\n" +
                "\"series_name\":\"The Moomins\",\n" +
                "\"publication_year\":1970,\n" +
                "\"ISBN\":\"0374453098\",\n" +
                "\"language\":\"en\",\n" +
                "\"thumbnail_path\":\"\",\n" +
                "\"cover_image_path\":\"\",\n" +
                "\"parallax_thumbnail\":{\"layers\":[\n" +
                "{\"image_path\":\"moominhouse\",\"name\":\"moominhouse_fall\", \"center_offset_x\":0, \"center_offset_y\":0, \"parallax_factor_x\":-0.1, \"parallax_factor_y\":-0.1},\n" +
                "{\"image_path\":\"moomintroll\",\"name\":\"moomintroll\", \"center_offset_x\":-0.1, \"center_offset_y\":0.3, \"parallax_factor_x\":0.2, \"parallax_factor_y\":0.2}\n" +
                "]},\n" +
                "\"tags\":[\"fiction\", \"melancholy\", \"kids\"]\n" +
                "}\n" +
                "]";
        List<Item>itemList;
        //act
        itemList= ItemsJSONParser.parse(jsonList);
        //assert
        assertEquals(itemList.size(), 1);
    }
    @Test
    public void ParsingNullJSONItemListProducesNullList() throws Exception {
        //arrange
        String jsonList = null;
        List<Item>itemList;
        //act
        itemList=ItemsJSONParser.parse(jsonList);
        //assert
        assertEquals(itemList, null);
    }
}