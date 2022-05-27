package hotel.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotel.data.OrderDetailRepository;
import hotel.data.StatsRepository;
import hotel.entity.OrderDetail;
import hotel.entity.SearchRoom;
import hotel.entity.Stats;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@Controller
@RequestMapping("/statistical")
public class StatisticalController {
	private final OrderDetailRepository odRepo;
	private final StatsRepository statsRepo;
	
	@Autowired
	public StatisticalController(OrderDetailRepository odRepo,  StatsRepository statsRepo) {
		this.odRepo = odRepo;
		this.statsRepo = statsRepo;
	}
	
	@ModelAttribute
	public void addOrderDetailtoModel(Model model){
		ArrayList<OrderDetail> orders = (ArrayList<OrderDetail>) odRepo.findAll();
		model.addAttribute("orderdetails", orders);
	}
	
	@ModelAttribute
	public void addStatsToModel(Model model) {
		List<Stats> statsS = (List<Stats>) statsRepo.findAll();
		model.addAttribute("statsS", statsS);
		
	}
	
	@GetMapping()
	public String showstatistical(Model model) {
		//model.addAttribute("search", new SearchRoom());
		//int roomid = 0;
		//model.addAttribute("roomid", roomid);
		return "statistical";
	}
	@GetMapping("/room")
	public String statisticalByRoom(@RequestParam(name="roomid") int roomid,Model model) {
		ArrayList<OrderDetail> orders = (ArrayList<OrderDetail>) odRepo.findByroomid(roomid);
		model.addAttribute("idroom", roomid);
		model.addAttribute("orderdetails", orders);
		return "statisticalroom";
	}
	@RequestMapping("/linechartdata")
	@ResponseBody
	public String getDataFromDB() {
		List<Stats> statsS = (List<Stats>) statsRepo.findAll();
		JsonArray jsonName = new JsonArray();
		JsonArray jsonRevenue = new JsonArray();
		JsonObject json = new JsonObject();
		statsS.forEach(stats->{
			jsonName.add(stats.getName_room());
			jsonRevenue.add(stats.getRevenue());
		});
		json.add("name", jsonName);
		json.add("revenue", jsonRevenue);
		return json.toString();
	}
	
	
	
}
