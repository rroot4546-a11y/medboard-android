package com.rroot.medboard.data

import com.rroot.medboard.data.TopicBlock.Bullets
import com.rroot.medboard.data.TopicBlock.Callout
import com.rroot.medboard.data.TopicBlock.Numbered
import com.rroot.medboard.data.TopicBlock.Paragraph
import com.rroot.medboard.data.TopicBlock.SubHeading
import com.rroot.medboard.data.TopicBlock.Table

internal object InfectiousTopics {

    private val sepsis = Topic(
        id = "id-sepsis",
        title = "Sepsis & Septic Shock",
        subtitle = "Surviving Sepsis 2021",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 131 \u2014 Severe sepsis and septic shock"),
            TopicReference("Davidson 24e", "Ch. 8 \u2014 Critical care (Sepsis)"),
        ),
        sections = listOf(
            TopicSection(
                "Definitions",
                listOf(
                    Paragraph(
                        "Sepsis (Sepsis-3) is life-threatening organ dysfunction caused by a dysregulated host response to infection, operationally defined by an increase in SOFA score \u2265 2 from baseline in the setting of suspected infection. Septic shock is a subset with persistent hypotension requiring vasopressors to maintain MAP \u2265 65 mmHg AND serum lactate > 2 mmol/L despite adequate fluid resuscitation \u2014 mortality > 40 %."
                    ),
                    Bullets(
                        listOf(
                            "qSOFA is an early clinical screen \u2014 \u2265 2 of: RR \u2265 22, SBP \u2264 100, altered mentation. It is NOT diagnostic.",
                            "NEWS2 / MEWS are more sensitive for early detection on wards than qSOFA.",
                        )
                    ),
                ),
            ),
            TopicSection(
                "First hour bundle (Surviving Sepsis 2021)",
                listOf(
                    Numbered(
                        listOf(
                            "Measure lactate (remeasure if > 2 mmol/L).",
                            "Obtain blood cultures before antibiotics, but do not delay antibiotics > 45 min.",
                            "Administer broad-spectrum antibiotics within 1 h for septic shock or probable sepsis; within 3 h if diagnosis uncertain and without shock.",
                            "Begin 30 mL/kg balanced crystalloid IV within 3 h for hypotension or lactate \u2265 4 mmol/L.",
                            "Start vasopressors (noradrenaline first) if MAP < 65 mmHg despite fluid \u2014 may begin peripherally while central access obtained.",
                            "Source control: drain, remove or debride infected sources as soon as feasible.",
                        ),
                        source = TopicSource.Both,
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Early appropriate antibiotics reduce mortality; every hour of delay in septic shock increases mortality by ~7 %.",
                    ),
                ),
            ),
            TopicSection(
                "Choice of empirical antibiotics",
                listOf(
                    Table(
                        title = "Common empirical regimens (tailor to local antibiogram)",
                        headers = listOf("Source / context", "Empirical option"),
                        rows = listOf(
                            listOf("Community-acquired sepsis, unknown source", "Ceftriaxone \u00b1 metronidazole \u00b1 amikacin"),
                            listOf("Hospital-acquired sepsis / neutropenic", "Piperacillin-tazobactam or meropenem \u00b1 vancomycin"),
                            listOf("Suspected MRSA (line, skin/soft tissue)", "Add vancomycin or linezolid"),
                            listOf("Suspected ESBL / Pseudomonas", "Meropenem, piperacillin-tazobactam, or ceftolozane-tazobactam"),
                            listOf("Post-splenectomy sepsis", "Ceftriaxone \u00b1 vancomycin"),
                            listOf("Necrotising fasciitis", "Carbapenem + clindamycin + vancomycin; urgent surgical debridement"),
                        ),
                    ),
                    Bullets(
                        listOf(
                            "De-escalate within 48\u201372 h based on cultures and susceptibilities.",
                            "Duration: usually 7 days for uncomplicated bloodstream infection; individualise for complicated infections and endocarditis.",
                            "Procalcitonin can guide duration in selected patients.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                ),
            ),
            TopicSection(
                "Haemodynamic and organ support",
                listOf(
                    Bullets(
                        listOf(
                            "Noradrenaline first-line vasopressor; add vasopressin (fixed 0.03 U/min) if rising noradrenaline need.",
                            "Adrenaline as second-line; dobutamine if low cardiac output persists.",
                            "Target MAP 65 mmHg; higher target (80\u201385) for chronic hypertension.",
                            "Hydrocortisone 200 mg/day (50 mg q6h) in refractory septic shock on vasopressors (APROCCHSS, ADRENAL).",
                            "Consider venovenous ECMO or renal replacement therapy for multiorgan failure.",
                            "Glycaemic target 7.8\u201310 mmol/L (140\u2013180 mg/dL); avoid tight control.",
                        )
                    ),
                    SubHeading("What has been deprioritised"),
                    Bullets(
                        listOf(
                            "Activated protein C (drotrecogin alfa) withdrawn.",
                            "Early goal-directed therapy (Rivers) no longer superior; usual care is sufficient (ProCESS, ARISE, ProMISe).",
                            "Routine albumin only in resistant patients; immunoglobulin not recommended.",
                        )
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Antibiotics within 1 h for septic shock \u2014 every hour of delay \u2191 mortality ~7 %.",
            "Noradrenaline first; add vasopressin before escalating noradrenaline infinitely.",
            "Balanced crystalloid (Plasma-Lyte/Hartmann's) preferred over saline.",
            "Low-dose hydrocortisone (200 mg/day) for refractory septic shock.",
            "qSOFA is a screening tool; NEWS2 is more sensitive for early deterioration.",
            "Source control (drain, remove catheter, debride) saves more lives than any drug.",
            "De-escalate empirical antibiotics at 48\u201372 h.",
            "Lactate \u2265 4 mmol/L triggers aggressive resuscitation regardless of BP.",
        ),
        qna = listOf(
            QnA(
                "SBP 78/40 after 30 mL/kg balanced crystalloid, lactate 4.5 \u2014 next step?",
                "Start noradrenaline infusion (peripherally if needed) targeting MAP \u2265 65, insert central access, add vasopressin if rising noradrenaline requirement.",
            ),
            QnA(
                "Septic shock on noradrenaline 0.5 mcg/kg/min and vasopressin \u2014 next consideration?",
                "Add hydrocortisone 200 mg/day; evaluate for refractory shock, consider adrenaline or methylene blue if vasoplegic.",
            ),
            QnA(
                "Neutropenic fever, no obvious source \u2014 empirical cover?",
                "Piperacillin-tazobactam (or meropenem). Add vancomycin if catheter infection, skin/soft tissue, haemodynamic instability or known MRSA.",
            ),
        ),
    )

    private val meningitis = Topic(
        id = "id-meningitis",
        title = "Meningitis & Encephalitis",
        subtitle = "Bacterial, viral and tuberculous",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 138\u2013139 \u2014 Meningitis, encephalitis"),
            TopicReference("Davidson 24e", "Ch. 28 \u2014 Neurology (Infections of the CNS)"),
        ),
        sections = listOf(
            TopicSection(
                "Clinical features",
                listOf(
                    Bullets(
                        listOf(
                            "Classic triad (only ~45 % sensitive): fever, neck stiffness, altered mentation.",
                            "Headache, photophobia, nausea/vomiting, purpuric rash (meningococcal), focal deficit, seizures.",
                            "Kernig and Brudzinski signs are specific but insensitive.",
                            "Encephalitis: altered consciousness, personality change, focal signs, seizures (think HSV temporal lobe involvement).",
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Initial management",
                listOf(
                    Numbered(
                        listOf(
                            "Rapid assessment \u2014 ABC, GCS, glucose, rule out raised ICP (papilloedema, focal signs, GCS < 11, immunocompromise, seizure).",
                            "Blood cultures \u00d7 2 immediately.",
                            "If no indication for CT before LP \u2192 lumbar puncture now.",
                            "If CT is indicated before LP \u2192 give antibiotics + dexamethasone first and do not wait for imaging.",
                            "Empirical antibiotics: ceftriaxone 2 g IV BD + vancomycin (pneumococcal resistance areas) + amoxicillin 2 g IV 4 hourly (if > 50 y, alcoholism, immunosuppression \u2014 covers Listeria).",
                            "Dexamethasone 10 mg IV QDS for 4 days \u2014 ideally before or with first dose of antibiotic for suspected pneumococcal meningitis.",
                            "Acyclovir 10 mg/kg IV 8 hourly if HSV encephalitis suspected (altered mental status, temporal lobe signs).",
                            "Isolate patients with suspected meningococcal disease; notify public health; offer chemoprophylaxis (ciprofloxacin or rifampicin) to close contacts.",
                        ),
                        source = TopicSource.Both,
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Do NOT delay antibiotics for LP; give them within 1 h of presentation. Blood cultures can be taken beforehand.",
                    ),
                ),
            ),
            TopicSection(
                "CSF interpretation",
                listOf(
                    Table(
                        title = "Typical CSF patterns",
                        headers = listOf("Parameter", "Bacterial", "Viral", "TB / fungal"),
                        rows = listOf(
                            listOf("Appearance", "Cloudy / turbid", "Clear", "Clear / cloudy"),
                            listOf("Opening pressure", "Raised", "Normal / mildly raised", "Raised"),
                            listOf("WCC", "> 1000, neutrophils", "10\u2013500, lymphocytes", "50\u2013500, lymphocytes"),
                            listOf("Glucose (CSF:serum)", "< 0.4", "\u2265 0.6 (may drop in mumps)", "< 0.4"),
                            listOf("Protein", "> 1 g/L", "< 1 g/L", "Markedly raised"),
                            listOf("Gram/culture", "Positive", "PCR positive", "Acid-fast / culture slow"),
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Targeted therapy",
                listOf(
                    Bullets(
                        listOf(
                            "S. pneumoniae: ceftriaxone + vancomycin \u2014 10\u201314 days.",
                            "N. meningitidis: ceftriaxone 7 days.",
                            "Listeria: amoxicillin + gentamicin 21 days.",
                            "H. influenzae type b: ceftriaxone 7\u201310 days.",
                            "Group B streptococcus (neonates, elderly): penicillin + gentamicin.",
                            "Cryptococcus neoformans (HIV, immunocompromised): amphotericin B + flucytosine induction, then fluconazole; serial LP for ICP management.",
                            "TB meningitis: RIPE + dexamethasone; extend duration (9\u201312 months).",
                        ),
                        source = TopicSource.Harrison,
                    ),
                ),
            ),
            TopicSection(
                "Encephalitis specifics",
                listOf(
                    Bullets(
                        listOf(
                            "HSV-1 most common sporadic cause in HICs \u2014 temporal lobe features, MRI sensitive.",
                            "Start IV acyclovir empirically until HSV PCR negative.",
                            "Autoimmune encephalitis (anti-NMDA receptor, LGI1) \u2014 consider in young patients with psychiatric features, movement disorders or seizures; paraneoplastic (teratoma) screening in young women.",
                        )
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Start empirical antibiotics within 1 h of suspected meningitis \u2014 never wait for LP.",
            "Dexamethasone before or with first antibiotic dose reduces mortality in pneumococcal meningitis.",
            "Add amoxicillin for listeria cover if > 50 y, alcoholism, immunosuppressed, pregnant.",
            "Purpuric rash in a febrile adult = meningococcal septicaemia until proven otherwise \u2014 IM benzylpenicillin in the community.",
            "Acyclovir empirically for suspected HSV encephalitis until PCR negative.",
            "Raised CSF opening pressure is a hallmark of cryptococcal meningitis \u2014 manage with therapeutic LPs.",
            "TB meningitis needs RIPE for at least 9\u201312 months with dexamethasone.",
            "Notify public health and treat close contacts of meningococcal disease.",
        ),
        qna = listOf(
            QnA(
                "70-year-old with neck stiffness, fever, GCS 11 \u2014 empirical antibiotics?",
                "Ceftriaxone + vancomycin + amoxicillin + dexamethasone (amoxicillin covers Listeria for age > 50).",
            ),
            QnA(
                "Young man with fever, seizures and temporal-lobe changes on MRI \u2014 treatment while awaiting LP?",
                "Start IV acyclovir 10 mg/kg 8 hourly empirically; add ceftriaxone + vancomycin + dexamethasone in case of bacterial co-infection.",
            ),
            QnA(
                "CSF shows 600 WCC (90 % lymphocytes), glucose 1.5 (serum 6), protein 2.0 g/L \u2014 diagnosis?",
                "TB meningitis (or cryptococcal) \u2014 low glucose, lymphocytic pleocytosis, high protein. Send AFB, TB-PCR, cryptococcal antigen.",
            ),
        ),
    )

    val all: List<Topic> = listOf(sepsis, meningitis)
}
