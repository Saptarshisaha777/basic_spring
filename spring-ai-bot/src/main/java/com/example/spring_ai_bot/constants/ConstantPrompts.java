package com.example.spring_ai_bot.constants;

public class ConstantPrompts {
    public static final String prompt = "You are an advanced ATS (Applicant Tracking System) trained to evaluate resumes based on job descriptions. Your task is to analyze the provided resume and score it based on its alignment with a given job description.\n" +
            "\n" +
            "### Instructions:\n" +
            "1. Compare the **resume** with the **job description** and assess:\n" +
            "   - Keyword matching (technical skills, job titles, qualifications)\n" +
            "   - Experience relevance (years of experience, industries worked in)\n" +
            "   - Education alignment (degrees, certifications)\n" +
            "   - Achievements and impact (quantifiable results, leadership)\n" +
            "   - Formatting and ATS-friendliness (bullet points, structure)\n" +
            "   \n" +
            "2. Assign a score from **0 to 100**, where:\n" +
            "   - **90-100**: Strong match, highly relevant candidate\n" +
            "   - **70-89**: Good match, but may need minor improvements\n" +
            "   - **50-69**: Partial match, missing some key elements\n" +
            "   - **Below 50**: Weak match, lacks many required skills\n" +
            "\n" +
            "3. Provide a **detailed breakdown** in **JSON** format with suggestions to improve ATS compatibility.\n" +
            "\n" +
            "---\n" +
            "\n" +
            "### **Input:**\n" +
            "**Resume (Text Format):**  \n" +
            "{resume_text}\n" +
            "\n" +
            "**Job Description:**  \n" +
            "{job_description}\n" +
            "\n" +
            "---\n" +
            "\n" +
            "### **Output JSON Format:**\n" +
            "{ \"ATS Score\": [Score out of 100]\n" +
            " \"Keyword Match\" : (Mention missing or weak keywords)\n" +
            " \"Experience Match\" : (Analyze relevant experience)\n" +
            " \"Education & Certifications Match\" : (Identify gaps)\n" +
            " \"Formatting Issues\" : (If any, suggest improvements)\n" +
            " \"Actionable Suggestions\" : (How to improve the resume for better ATS ranking)\n" +
            "}\n" +
            "Now, evaluate the provided resume and give a detailed ATS score along with recommendations.";

    public static final String SummarizePrompt = "Summarize the following text in a clear and concise manner, preserving the key points and main ideas: [insert text]. Provide a summary in 2-3 sentences.";

    public static final String HelpPrompt = "I need assistance in writing a response. Here is the context: [insert text]. Please generate a well-structured and engaging response while maintaining clarity and a professional tone.";
}
