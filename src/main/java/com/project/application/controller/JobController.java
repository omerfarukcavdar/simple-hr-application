package com.project.application.controller;

import com.project.application.model.Applicant;
import com.project.application.model.Job;
import com.project.application.service.ApplicantService;
import com.project.application.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@SessionAttributes("selectedJob")
public class JobController {

    @Autowired
    JobService jobService;

    @Autowired
    ApplicantService applicantService;

    @GetMapping("/applylist")
    public String applyList(Model model){

        model.addAttribute("allJobs",jobService.findAll());
        return "applylist";
    }

    @RequestMapping(value = {"/jobList/applyJob/{id}"}, method = RequestMethod.GET)
    public String applyJob(@PathVariable("id") int id, Model model){
        Applicant applicant=new Applicant();
        model.addAttribute("selectedJob",jobService.findById(id));
        model.addAttribute("applicantRegister",applicant);
        return "apply";
    }

    @RequestMapping(value = {"/jobList/applyJob"}, method = RequestMethod.POST)
    public String saveApplicant(@ModelAttribute("applicantRegister") Applicant applicantRegister,
                                @ModelAttribute("selectedJob") Job selectedJob,SessionStatus status
    )
    {
        applicantRegister.setJob(selectedJob);
        applicantService.save(applicantRegister);
        status.setComplete();
        return "apply";
    }

    @GetMapping("/manage")
    public String manage(Model model){

        Job job = new Job();
        model.addAttribute("jobRegister",job);
        model.addAttribute("allJobs",jobService.findAll());
        return "manage";

    }

    @RequestMapping(value = {"/jobList/editJob"}, method = RequestMethod.POST)
    public String editJob(@ModelAttribute("editJob") Job editJob, Model model) {
        try {
            Job job = jobService.findById(editJob.getJobId());
            if (!job.equals(editJob)) {
                jobService.update(editJob);
                model.addAttribute("msg", "success");
            } else {
                model.addAttribute("msg", "same");
            }
        } catch (Exception e) {
            model.addAttribute("msg", "fail");
        }
        return "redirect:/manage";
    }



    @RequestMapping(value = {"/jobList/saveJob"}, method = RequestMethod.POST)
    public String saveJob(@ModelAttribute("jobRegister") Job jobRegister,
                           final RedirectAttributes redirectAttributes) {
        try {
            jobRegister.setLastApplicationDate(LocalDateTime.now());
            jobService.save(jobRegister);
            redirectAttributes.addFlashAttribute("msg", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "fail");
        }

        return "redirect:/home";
    }

    @RequestMapping(value = "/jobList/{operation}/{id}", method = RequestMethod.GET)
    public String jobOperation(@PathVariable("operation") String operation,
                                @PathVariable("id") int id, final RedirectAttributes redirectAttributes,
                                Model model) {
         if (operation.equals("delete")) {
            if (jobService.delete(id)) {

                return "redirect:/home";
            }
        } else if (operation.equals("edit")) {
            Job editJob = jobService.findById(id);
            if (editJob != null) {
                model.addAttribute("editJob", editJob);
                return "edit";
            } else {
                redirectAttributes.addFlashAttribute("msg", "notfound");
            }
        }
         else if(operation.equals("details")){
             model.addAttribute("allApplicants",applicantService.findAllByJob(jobService.findById(id)));
             return "detail";

         }
        return "redirect:/home";
    }


}
