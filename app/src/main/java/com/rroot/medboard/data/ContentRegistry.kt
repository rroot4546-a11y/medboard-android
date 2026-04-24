package com.rroot.medboard.data

/**
 * All specialties and their topics, assembled from the per-specialty
 * content files. Topics that are still under construction appear as
 * \u201ccoming soon\u201d stubs so users can see the planned scope. Finished
 * topics have sections, tables, pearls, Q&A and per-paragraph source
 * attributions.
 */
object ContentRegistry {

    private fun topicStub(id: String, title: String, subtitle: String = "") = Topic(
        id = id,
        title = title,
        subtitle = subtitle,
    )

    private val cardiologyTopics: List<Topic> = CardiologyTopics.all +
        CardiologyTopicsPart2.all +
        listOf(
            topicStub("card-brady", "Bradyarrhythmias & AV block"),
            topicStub("card-svt", "Supraventricular Tachycardias"),
            topicStub("card-vt", "Ventricular Tachycardia & Fibrillation"),
        )

    private val respiratoryTopics: List<Topic> = RespiratoryTopics.all +
        listOf(
            topicStub("resp-cap", "Community-acquired Pneumonia"),
            topicStub("resp-hap", "Hospital-acquired & Ventilator-associated Pneumonia"),
            topicStub("resp-tb", "Tuberculosis"),
            topicStub("resp-ph", "Pulmonary Hypertension"),
            topicStub("resp-ild", "Interstitial Lung Disease"),
            topicStub("resp-pleural", "Pleural Effusion & Pneumothorax"),
            topicStub("resp-ca", "Lung Cancer"),
        )

    private val nephrologyTopics: List<Topic> = NephrologyTopics.all +
        listOf(
            topicStub("neph-gn", "Glomerulonephritis & Nephrotic Syndrome"),
            topicStub("neph-electrolytes", "Electrolyte Disorders"),
            topicStub("neph-acid-base", "Acid\u2013Base Disorders"),
            topicStub("neph-uti", "Urinary Tract Infection & Pyelonephritis"),
            topicStub("neph-renal-transplant", "Renal Replacement & Transplantation"),
        )

    private val endocrinologyTopics: List<Topic> = listOf(
        topicStub("endo-dm1", "Type 1 Diabetes Mellitus"),
    ) + EndocrinologyTopics.all + listOf(
        topicStub("endo-adrenal", "Adrenal Insufficiency & Cushing\u2019s"),
        topicStub("endo-pituitary", "Pituitary Disorders"),
        topicStub("endo-calcium", "Calcium & Bone Metabolism"),
        topicStub("endo-pcos", "PCOS & Hirsutism"),
    )

    private val gastroTopics: List<Topic> = listOf(
        topicStub("gi-gerd", "GERD & Peptic Ulcer Disease"),
    ) + GastroTopics.all + listOf(
        topicStub("gi-lower-gib", "Lower GI Bleeding"),
        topicStub("gi-ibd", "Inflammatory Bowel Disease"),
        topicStub("gi-ibs", "Irritable Bowel Syndrome"),
        topicStub("gi-coeliac", "Coeliac Disease"),
        topicStub("gi-hepatitis", "Viral Hepatitis"),
        topicStub("gi-pancreatitis", "Acute & Chronic Pancreatitis"),
        topicStub("gi-gb", "Gallbladder & Biliary Disease"),
    )

    private val infectiousTopics: List<Topic> = InfectiousTopics.all +
        listOf(
            topicStub("id-hiv", "HIV Infection"),
            topicStub("id-malaria", "Malaria"),
            topicStub("id-tb", "Tuberculosis"),
            topicStub("id-cdiff", "Clostridioides difficile Infection"),
            topicStub("id-stewardship", "Antimicrobial Stewardship"),
        )

    private val neurologyTopics: List<Topic> = NeurologyTopics.all +
        listOf(
            topicStub("neuro-tia", "Transient Ischaemic Attack"),
            topicStub("neuro-headache", "Headache Disorders"),
            topicStub("neuro-ms", "Multiple Sclerosis"),
            topicStub("neuro-pd", "Parkinson\u2019s Disease"),
            topicStub("neuro-dementia", "Dementia Syndromes"),
            topicStub("neuro-gbs-mg", "Guillain\u2013Barr\u00e9 & Myasthenia Gravis"),
            topicStub("neuro-spinal", "Spinal Cord Disease"),
        )

    val specialties: List<Specialty> = listOf(
        Specialty(
            id = "cardiology",
            name = "Cardiology",
            blurb = "Coronary disease, heart failure, arrhythmias, valves and more.",
            code = "CV",
            topics = cardiologyTopics,
        ),
        Specialty(
            id = "pulmonology",
            name = "Respiratory Medicine",
            blurb = "Obstructive & restrictive lung disease, pneumonia, PE, pleural disease.",
            code = "RS",
            topics = respiratoryTopics,
        ),
        Specialty(
            id = "nephrology",
            name = "Nephrology",
            blurb = "AKI, CKD, glomerular disease, electrolyte and acid-base disorders.",
            code = "RN",
            topics = nephrologyTopics,
        ),
        Specialty(
            id = "endocrinology",
            name = "Endocrinology",
            blurb = "Diabetes, thyroid, adrenal, pituitary and bone disease.",
            code = "EN",
            topics = endocrinologyTopics,
        ),
        Specialty(
            id = "gastroenterology",
            name = "Gastroenterology & Hepatology",
            blurb = "Oesophageal to hepatobiliary disease, IBD and GI bleeding.",
            code = "GI",
            topics = gastroTopics,
        ),
        Specialty(
            id = "infectious",
            name = "Infectious Diseases",
            blurb = "Sepsis, HIV, tropical infections, healthcare-associated infection.",
            code = "ID",
            topics = infectiousTopics,
        ),
        Specialty(
            id = "neurology",
            name = "Neurology",
            blurb = "Stroke, seizures, neuromuscular and neurodegenerative disease.",
            code = "NE",
            topics = neurologyTopics,
        ),
        Specialty(
            id = "haemonc",
            name = "Haematology & Oncology",
            blurb = "Anaemias, haemostasis, leukaemias, lymphomas and common solid tumours.",
            code = "HO",
            topics = listOf(
                topicStub("heme-ida", "Iron-Deficiency Anaemia & Anaemia of Chronic Disease"),
                topicStub("heme-b12", "Megaloblastic & Haemolytic Anaemias"),
                topicStub("heme-sickle", "Sickle Cell & Thalassaemia"),
                topicStub("heme-bleeding", "Bleeding Disorders & Thrombocytopenia"),
                topicStub("heme-thrombophilia", "Venous Thromboembolism & Thrombophilias"),
                topicStub("heme-leuk", "Acute & Chronic Leukaemias"),
                topicStub("heme-lymphoma", "Hodgkin & Non-Hodgkin Lymphoma"),
                topicStub("heme-mm", "Multiple Myeloma & Plasma Cell Disorders"),
                topicStub("onc-oncological-emergencies", "Oncological Emergencies"),
            ),
        ),
        Specialty(
            id = "rheumatology",
            name = "Rheumatology",
            blurb = "Inflammatory and connective-tissue diseases, vasculitis, gout.",
            code = "RH",
            topics = listOf(
                topicStub("rheum-ra", "Rheumatoid Arthritis"),
                topicStub("rheum-sle", "Systemic Lupus Erythematosus"),
                topicStub("rheum-spa", "Seronegative Spondyloarthritides"),
                topicStub("rheum-ssc", "Systemic Sclerosis"),
                topicStub("rheum-sjogren", "Sj\u00f6gren\u2019s Syndrome"),
                topicStub("rheum-myositis", "Inflammatory Myopathies"),
                topicStub("rheum-vasculitis", "Vasculitides"),
                topicStub("rheum-gout", "Gout & Pseudogout"),
                topicStub("rheum-oa", "Osteoarthritis"),
            ),
        ),
        Specialty(
            id = "emergencies",
            name = "Medical Emergencies",
            blurb = "ACLS, shock, toxicology and rapid-response pearls.",
            code = "EM",
            topics = listOf(
                topicStub("em-acls", "ACLS \u2013 Adult Cardiac Arrest"),
                topicStub("em-shock", "Shock & Vasoactive Support"),
                topicStub("em-anaphylaxis", "Anaphylaxis"),
                topicStub("em-tox", "Common Poisonings & Antidotes"),
                topicStub("em-envenomation", "Envenomation & Bites"),
                topicStub("em-heatstroke", "Heat Stroke & Hypothermia"),
            ),
        ),
    )

    fun specialty(id: String): Specialty? = specialties.firstOrNull { it.id == id }

    fun topic(id: String): Topic? =
        specialties.asSequence().flatMap { it.topics.asSequence() }.firstOrNull { it.id == id }

    fun specialtyFor(topic: Topic): Specialty? =
        specialties.firstOrNull { s -> s.topics.any { it.id == topic.id } }

    /** Flat search across all topics for a case-insensitive substring match. */
    fun search(query: String): List<Topic> {
        val q = query.trim()
        if (q.isEmpty()) return emptyList()
        return specialties.flatMap { it.topics }.filter {
            it.title.contains(q, ignoreCase = true) ||
                it.subtitle.contains(q, ignoreCase = true)
        }
    }
}
