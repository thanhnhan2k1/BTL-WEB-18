package hotel.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import hotel.data.StatsRepository;
import hotel.entity.Stats;

@Controller
@RequestMapping("/adminpage")
public class AdminHomeController {
	private final StatsRepository statsRepo;

	@Autowired
	public AdminHomeController(StatsRepository statsRepo) {
		this.statsRepo = statsRepo;
	}

	@ModelAttribute
	public void addStatsToModel(Model model) {
		List<Stats> statsS = (List<Stats>) statsRepo.findAll();
		model.addAttribute("statsS", statsS);

	}

	@RequestMapping("/linechartdata")
	@ResponseBody
	public String getDataFromDB() {
		List<Stats> statsS = (List<Stats>) statsRepo.findAll();
		JsonArray jsonName = new JsonArray();
		JsonArray jsonRevenue = new JsonArray();
		JsonObject json = new JsonObject();
		statsS.forEach(stats -> {
			jsonName.add(stats.getName_room());
			jsonRevenue.add(stats.getRevenue());
		});
		json.add("name", jsonName);
		json.add("revenue", jsonRevenue);
		return json.toString();
	}
	@GetMapping
	public String homeAdmin() {
		return "stats";
	}
	
}
