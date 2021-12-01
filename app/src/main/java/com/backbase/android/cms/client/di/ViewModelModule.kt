package com.backbase.android.cms.client.di

import com.backbase.android.cms.client.ui.SharedPostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * This Module is part of Koin Dependencies it refers to setup the shared view model
 */
val appModule = module {
    viewModel { SharedPostViewModel(get()) }
}