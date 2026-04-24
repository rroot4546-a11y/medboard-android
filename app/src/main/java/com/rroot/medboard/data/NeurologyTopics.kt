package com.rroot.medboard.data

import com.rroot.medboard.data.TopicBlock.Bullets
import com.rroot.medboard.data.TopicBlock.Callout
import com.rroot.medboard.data.TopicBlock.Numbered
import com.rroot.medboard.data.TopicBlock.Paragraph
import com.rroot.medboard.data.TopicBlock.SubHeading
import com.rroot.medboard.data.TopicBlock.Table

internal object NeurologyTopics {

    private val stroke = Topic(
        id = "neuro-stroke",
        title = "Ischaemic & Haemorrhagic Stroke",
        subtitle = "Hyperacute and secondary prevention",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 428, 431 \u2014 Cerebrovascular disease"),
            TopicReference("Davidson 24e", "Ch. 28 \u2014 Neurology (Cerebrovascular disease)"),
        ),
        sections = listOf(
            TopicSection(
                "Hyperacute assessment",
                listOf(
                    Bullets(
                        listOf(
                            "Sudden focal neurological deficit \u2192 assume stroke until proven otherwise; FAST-ED or NIHSS for severity.",
                            "Non-contrast CT head to exclude haemorrhage; CT angiography (with perfusion if > 4.5 h) identifies large-vessel occlusion and salvageable tissue.",
                            "Finger-prick glucose (rule out hypoglycaemia), BP, ECG (AF), pregnancy test, focused history (onset, last known well, anticoagulants).",
                        ),
                        source = TopicSource.Both,
                    ),
                ),
            ),
            TopicSection(
                "Reperfusion therapy (ischaemic stroke)",
                listOf(
                    SubHeading("IV thrombolysis"),
                    Bullets(
                        listOf(
                            "Alteplase 0.9 mg/kg (max 90 mg, 10 % as bolus) within 4.5 h of symptom onset \u2014 or tenecteplase 0.25 mg/kg bolus as an alternative.",
                            "Absolute contraindications: intracranial haemorrhage, recent major surgery or bleeding, recent stroke/head trauma (< 3 months), known arteriovenous malformation, INR > 1.7, platelets < 100, BP > 185/110 despite treatment.",
                            "Wake-up stroke or unknown onset with mismatch on MRI DWI-FLAIR: thrombolysis within 9 h of midpoint of sleep (WAKE-UP trial).",
                        )
                    ),
                    SubHeading("Mechanical thrombectomy"),
                    Bullets(
                        listOf(
                            "Large-vessel occlusion (ICA, M1, basilar) up to 6 h \u2014 routine; 6\u201324 h if favourable perfusion imaging (DAWN, DEFUSE-3).",
                            "Combined with IV thrombolysis if eligible \u2014 do not skip thrombolysis unless contraindicated.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Permissive hypertension (BP up to 220/120) in ischaemic stroke unless thrombolysed (then < 180/105 for 24 h). In haemorrhagic stroke target SBP 130\u2013150 mmHg (INTERACT-2, ATACH-2).",
                    ),
                ),
            ),
            TopicSection(
                "Secondary prevention",
                listOf(
                    Numbered(
                        listOf(
                            "Antiplatelet: aspirin 75 mg lifelong; aspirin + clopidogrel for 21 days after minor stroke / high-risk TIA (CHANCE, POINT).",
                            "Statin \u2014 high-intensity for atherosclerotic stroke; LDL target < 1.8 mmol/L.",
                            "BP control \u2014 start within days; target < 130/80.",
                            "Anticoagulation for cardio-embolic stroke in AF \u2014 DOAC preferred; start 1\u201314 days after stroke depending on size and haemorrhagic transformation risk.",
                            "Carotid endarterectomy for 70\u201399 % symptomatic stenosis within 2 weeks; consider for 50\u201369 % in selected patients.",
                            "Lifestyle: smoking cessation, diet, weight, diabetes control.",
                        ),
                    ),
                ),
            ),
            TopicSection(
                "Intracerebral haemorrhage",
                listOf(
                    Bullets(
                        listOf(
                            "Causes: hypertension (deep structures), cerebral amyloid angiopathy (lobar, elderly), AVM, tumour, anticoagulation, illicit drugs.",
                            "Urgent BP reduction to SBP 130\u2013150 mmHg with IV labetalol or nicardipine.",
                            "Reverse anticoagulation promptly \u2014 prothrombin complex concentrate + vitamin K for warfarin; idarucizumab for dabigatran; andexanet for factor Xa.",
                            "Neurosurgical consultation: posterior fossa haemorrhage, cerebellar > 3 cm, obstructive hydrocephalus.",
                            "Subarachnoid haemorrhage: sudden severe headache \u2192 CT + LP (xanthochromia) or CT-angiography; nimodipine 60 mg 4 hourly for 21 days to prevent vasospasm; coil or clip aneurysm within 72 h.",
                        ),
                        source = TopicSource.Both,
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Time is brain \u2014 minimise door-to-needle and door-to-groin times.",
            "Tenecteplase is non-inferior to alteplase for stroke thrombolysis and is administered as a single bolus.",
            "Thrombectomy window extends to 24 h with favourable imaging (DAWN, DEFUSE-3).",
            "Permissive hypertension post-stroke unless thrombolysed; in ICH target lower (SBP 130\u2013150).",
            "CHANCE/POINT: aspirin + clopidogrel for 21 days after minor stroke or high-risk TIA reduces recurrence.",
            "Starting DOAC 1\u201314 days post-cardio-embolic stroke depending on size and risk (ELAN, TIMING).",
            "SAH: nimodipine for 21 days prevents vasospasm and improves outcomes.",
            "Cerebellar haemorrhage > 3 cm needs surgical evacuation.",
        ),
        qna = listOf(
            QnA(
                "Acute MCA syndrome NIHSS 18, onset 3 h ago, BP 170/95 \u2014 management?",
                "IV alteplase (or tenecteplase) immediately; CT angiography for large-vessel occlusion \u2192 mechanical thrombectomy if present.",
            ),
            QnA(
                "Minor ischaemic stroke, NIHSS 2, non-cardioembolic \u2014 initial antiplatelet strategy?",
                "Aspirin + clopidogrel for 21 days, then aspirin alone (CHANCE/POINT).",
            ),
            QnA(
                "Hypertensive intracerebral haemorrhage, BP 210/110 \u2014 target and drug?",
                "Target SBP 130\u2013150 mmHg with IV labetalol or nicardipine infusion.",
            ),
        ),
    )

    private val status = Topic(
        id = "neuro-seizures",
        title = "Seizures & Status Epilepticus",
        subtitle = "Emergency management and chronic therapy",
        references = listOf(
            TopicReference("Harrison 21e", "Ch. 425 \u2014 Seizures and epilepsy"),
            TopicReference("Davidson 24e", "Ch. 28 \u2014 Neurology (Epilepsy)"),
        ),
        sections = listOf(
            TopicSection(
                "Status epilepticus",
                listOf(
                    Paragraph(
                        "Status epilepticus is defined operationally as continuous seizure activity or recurrent seizures without recovery of consciousness lasting \u2265 5 minutes (for generalised convulsive status) or \u2265 10 minutes for focal or absence status. It is a neurological emergency \u2014 neuronal injury begins after ~30 minutes."
                    ),
                    SubHeading("Staged pharmacotherapy"),
                    Numbered(
                        listOf(
                            "First 5\u201320 min: benzodiazepine \u2014 lorazepam 4 mg IV (0.1 mg/kg, max 4 mg per dose, may repeat) OR midazolam 10 mg IM / buccal / intranasal OR diazepam 10 mg IV.",
                            "20\u201340 min: second-line AED \u2014 levetiracetam 60 mg/kg IV (max 4500 mg) OR valproate 40 mg/kg IV (max 3000 mg) OR fosphenytoin 20 mg PE/kg (avoid in hepatic failure). Established-SE trial: all three have similar efficacy.",
                            "Refractory (> 30\u201340 min): intubate, continuous EEG, IV anaesthetic \u2014 midazolam, propofol or pentobarbital infusion.",
                            "Super-refractory (> 24 h): ketamine, immunotherapy (if autoimmune), ketogenic diet, tailored to aetiology.",
                        ),
                        source = TopicSource.Harrison,
                    ),
                    SubHeading("Work-up while treating"),
                    Bullets(
                        listOf(
                            "Glucose, electrolytes (Na, Ca, Mg), urea, creatinine, LFTs, tox screen, ABG, FBC.",
                            "Pregnancy test (eclampsia), anti-epileptic drug levels if on therapy.",
                            "CT head \u00b1 MRI; LP if meningitis suspected; continuous EEG if coma persists.",
                            "Treat reversible causes: hypoglycaemia (glucose with thiamine if alcoholism), hyponatraemia, infection, anti-epileptic withdrawal, toxic ingestion.",
                        )
                    ),
                    Callout(
                        CalloutKind.Warning,
                        "Do NOT use phenytoin alone as a \u2018fast push\u2019 \u2014 use fosphenytoin or infuse phenytoin \u2264 50 mg/min with cardiac monitoring (risk of hypotension and arrhythmia).",
                    ),
                ),
            ),
            TopicSection(
                "New-onset seizure in adults",
                listOf(
                    Bullets(
                        listOf(
                            "Take a collateral history to distinguish seizure (post-ictal confusion, tongue-biting, incontinence) from syncope and psychogenic non-epileptic seizures.",
                            "Investigate for provoked vs unprovoked: fever, infection, electrolytes, drugs, alcohol withdrawal, stroke, tumour.",
                            "Imaging: MRI brain preferred; CT head if acute or urgent.",
                            "EEG for epilepsy syndrome classification.",
                            "AED usually considered after a second unprovoked seizure or first seizure with high recurrence risk (structural lesion, abnormal EEG, nocturnal).",
                        )
                    ),
                    SubHeading("Choice of AED"),
                    Table(
                        title = "First-line AEDs by syndrome",
                        headers = listOf("Seizure type", "First-line", "Notable alternatives"),
                        rows = listOf(
                            listOf("Focal", "Lamotrigine, levetiracetam", "Carbamazepine, oxcarbazepine, zonisamide"),
                            listOf("Generalised tonic-clonic", "Valproate (male), lamotrigine (female)", "Levetiracetam, topiramate"),
                            listOf("Absence", "Ethosuximide, valproate", "Lamotrigine"),
                            listOf("Myoclonic", "Valproate, levetiracetam", "Topiramate"),
                        ),
                    ),
                    Callout(
                        CalloutKind.Pitfall,
                        "Valproate is teratogenic and reduces IQ in exposed offspring \u2014 avoid in girls and women of childbearing age unless absolutely necessary and no alternative exists.",
                    ),
                ),
            ),
        ),
        boardPearls = listOf(
            "Benzodiazepine is the first-line drug in status epilepticus \u2014 not phenytoin, not levetiracetam.",
            "Levetiracetam, valproate and fosphenytoin are equivalent second-line options (Established-SE).",
            "Phenytoin must be infused \u2264 50 mg/min with cardiac monitoring.",
            "Do not forget IV thiamine before glucose in alcoholism to avoid Wernicke's.",
            "Keppra has negligible drug interactions \u2014 useful in polypharmacy; watch for behavioural side effects.",
            "Lamotrigine causes Stevens-Johnson syndrome with rapid titration \u2014 titrate slowly over weeks.",
            "Sodium-channel blockers (carbamazepine, phenytoin) can worsen absence and myoclonic seizures.",
            "Nonconvulsive status epilepticus \u2014 persistent coma after clinical seizure termination; get EEG.",
        ),
        qna = listOf(
            QnA(
                "Patient seizing 7 minutes despite IV lorazepam \u2014 next drug?",
                "A second-line AED: IV levetiracetam, valproate, or fosphenytoin.",
            ),
            QnA(
                "Alcoholic arrives obtunded with seizures and hypoglycaemia \u2014 first two drugs?",
                "IV thiamine first, then IV glucose (and benzodiazepine for the seizure).",
            ),
            QnA(
                "20-year-old with juvenile myoclonic epilepsy, pregnant \u2014 preferred AED?",
                "Avoid valproate; use lamotrigine or levetiracetam \u2014 high-dose folate pre-conception and through pregnancy.",
            ),
        ),
    )

    val all: List<Topic> = listOf(stroke, status)
}
