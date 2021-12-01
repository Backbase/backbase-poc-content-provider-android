package com.backbase.android.cms.client.di

import com.backbase.android.cms.client.ui.SharedPostViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { SharedPostViewModel(get()) }
}