package com.faithyee.androidlearningdemo.ui.view;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.faithyee.androidlearningdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本实现
 *
 */
public class ViewDemoActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager pager;
    List<PageModel> pageModels = new ArrayList<>();

    {
        pageModels.add(new PageModel(R.string.title_thumb_up, R.layout.practice_thumb_up_view_layout));

        pageModels.add(new PageModel(R.string.title_draw_color, R.layout.practice_color));
        pageModels.add(new PageModel(R.string.title_draw_circle, R.layout.practice_circle));
        pageModels.add(new PageModel(R.string.title_draw_rect, R.layout.practice_rect));
        pageModels.add(new PageModel(R.string.title_draw_point, R.layout.practice_point));
        pageModels.add(new PageModel(R.string.title_draw_oval, R.layout.practice_oval));
        pageModels.add(new PageModel(R.string.title_draw_line, R.layout.practice_line));
        pageModels.add(new PageModel(R.string.title_draw_round_rect, R.layout.practice_round_rect));
        pageModels.add(new PageModel(R.string.title_draw_arc, R.layout.practice_arc));
        pageModels.add(new PageModel(R.string.title_draw_path, R.layout.practice_path));
        pageModels.add(new PageModel(R.string.title_draw_histogram, R.layout.practice_histogram));
        pageModels.add(new PageModel(R.string.title_draw_pie_chart, R.layout.practice_pie_chart));

        pageModels.add(new PageModel(R.string.title_linear_gradient, R.layout.practice_linear_gradient));
        pageModels.add(new PageModel(R.string.title_radial_gradient, R.layout.practice_radial_gradient));
        pageModels.add(new PageModel(R.string.title_sweep_gradient, R.layout.practice_sweep_gradient));
        pageModels.add(new PageModel(R.string.title_bitmap_shader, R.layout.practice_bitmap_shader));
        pageModels.add(new PageModel(R.string.title_compose_shader, R.layout.practice_compose_shader));
        pageModels.add(new PageModel(R.string.title_lighting_color_filter, R.layout.practice_lighting_color_filter));
        pageModels.add(new PageModel(R.string.title_color_matrix_color_filter, R.layout.practice_color_matrix_color_filter));
        pageModels.add(new PageModel(R.string.title_xfermode, R.layout.practice_xfermode));
        pageModels.add(new PageModel(R.string.title_stroke_cap, R.layout.practice_stroke_cap));
        pageModels.add(new PageModel(R.string.title_stroke_join, R.layout.practice_stroke_join));
        pageModels.add(new PageModel(R.string.title_stroke_miter, R.layout.practice_stroke_miter));
        pageModels.add(new PageModel(R.string.title_path_effect, R.layout.practice_path_effect));
        pageModels.add(new PageModel(R.string.title_shader_layer, R.layout.practice_shadow_layer));
        pageModels.add(new PageModel(R.string.title_mask_filter, R.layout.practice_mask_filter));
        pageModels.add(new PageModel(R.string.title_fill_path, R.layout.practice_fill_path));
        pageModels.add(new PageModel(R.string.title_text_path, R.layout.practice_text_path));

        pageModels.add(new PageModel(R.string.title_draw_text, R.layout.practice_draw_text));
        pageModels.add(new PageModel(R.string.title_static_layout, R.layout.practice_static_layout));
        pageModels.add(new PageModel(R.string.title_set_text_size, R.layout.practice_set_text_size));
        pageModels.add(new PageModel(R.string.title_set_typeface, R.layout.practice_set_typeface));
        pageModels.add(new PageModel(R.string.title_set_fake_bold_text, R.layout.practice_set_fake_bold_text));
        pageModels.add(new PageModel(R.string.title_set_strike_thru_text, R.layout.practice_set_strike_thru_text));
        pageModels.add(new PageModel(R.string.title_set_underline_text, R.layout.practice_set_underline_text));
        pageModels.add(new PageModel(R.string.title_set_text_skew_x, R.layout.practice_set_text_skew_x));
        pageModels.add(new PageModel(R.string.title_set_text_scale_x, R.layout.practice_set_text_scale_x));
        pageModels.add(new PageModel(R.string.title_set_text_align, R.layout.practice_set_text_align));
        pageModels.add(new PageModel(R.string.title_get_font_spacing, R.layout.practice_get_font_spacing));
        pageModels.add(new PageModel(R.string.title_measure_text, R.layout.practice_measure_text));
        pageModels.add(new PageModel(R.string.title_get_text_bounds, R.layout.practice_get_text_bounds));
        pageModels.add(new PageModel(R.string.title_get_font_metrics, R.layout.practice_get_font_metrics));

        pageModels.add(new PageModel(R.string.title_clip_rect, R.layout.practice_clip_rect));
        pageModels.add(new PageModel(R.string.title_clip_path, R.layout.practice_clip_path));
        pageModels.add(new PageModel(R.string.title_translate, R.layout.practice_translate));
        pageModels.add(new PageModel(R.string.title_scale, R.layout.practice_scale));
        pageModels.add(new PageModel(R.string.title_rotate, R.layout.practice_rotate));
        pageModels.add(new PageModel(R.string.title_skew, R.layout.practice_skew));
        pageModels.add(new PageModel(R.string.title_matrix_translate, R.layout.practice_matrix_translate));
        pageModels.add(new PageModel(R.string.title_matrix_scale, R.layout.practice_matrix_scale));
        pageModels.add(new PageModel(R.string.title_matrix_rotate, R.layout.practice_matrix_rotate));
        pageModels.add(new PageModel(R.string.title_matrix_skew, R.layout.practice_matrix_skew));
        pageModels.add(new PageModel(R.string.title_camera_rotate, R.layout.practice_camera_rotate));
        pageModels.add(new PageModel(R.string.title_camera_rotate_fixed, R.layout.practice_camera_rotate_fixed));
        pageModels.add(new PageModel(R.string.title_camera_rotate_hitting_face, R.layout.practice_camera_rotate_hitting_face));
        pageModels.add(new PageModel(R.string.title_flipboard, R.layout.practice_flipboard));

        pageModels.add(new PageModel(R.string.title_after_on_draw, R.layout.practice_after_on_draw));
        pageModels.add(new PageModel(R.string.title_before_on_draw, R.layout.practice_before_on_draw));
        pageModels.add(new PageModel(R.string.title_on_draw_layout, R.layout.practice_on_draw_layout));
        pageModels.add(new PageModel(R.string.title_dispatch_draw, R.layout.practice_dispatch_draw));
        pageModels.add(new PageModel(R.string.title_after_on_draw_foreground, R.layout.practice_after_on_draw_foreground));
        pageModels.add(new PageModel(R.string.title_before_on_draw_foreground, R.layout.practice_before_on_draw_foreground));
        pageModels.add(new PageModel(R.string.title_after_draw, R.layout.practice_after_draw));
        pageModels.add(new PageModel(R.string.title_before_draw, R.layout.practice_before_draw));

        pageModels.add(new PageModel(R.string.title_translation, R.layout.practice_translation));
        pageModels.add(new PageModel(R.string.title_rotation, R.layout.practice_rotation));
        pageModels.add(new PageModel(R.string.title_scale_anim, R.layout.practice_scale_anim));
        pageModels.add(new PageModel(R.string.title_alpha, R.layout.practice_alpha));
        pageModels.add(new PageModel(R.string.title_multi_properties, R.layout.practice_multi_properties));
        pageModels.add(new PageModel(R.string.title_duration, R.layout.practice_duration));
        pageModels.add(new PageModel(R.string.title_interpolator, R.layout.practice_interpolator));
        pageModels.add(new PageModel(R.string.title_object_animator, R.layout.practice_object_animator));

        pageModels.add(new PageModel(R.string.title_argb_evaluator, R.layout.practice_argb_evaluator));
        pageModels.add(new PageModel(R.string.title_hsv_evaluator, R.layout.practice_hsv_evaluator));
        pageModels.add(new PageModel(R.string.title_of_object, R.layout.practice_of_object));
        pageModels.add(new PageModel(R.string.title_property_values_holder, R.layout.practice_property_values_holder));
        pageModels.add(new PageModel(R.string.title_animator_set, R.layout.practice_animator_set));
        pageModels.add(new PageModel(R.string.title_keyframe, R.layout.practice_keyframe));


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_view_demo);
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                PageModel pageModel = pageModels.get(position);
                return PageFragment.newInstance(pageModel.practiceLayoutRes);
            }

            @Override
            public int getCount() {
                return pageModels.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return getString(pageModels.get(position).titleRes);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(pager);

    }

    private class PageModel {
        @StringRes
        int titleRes;
        @LayoutRes int practiceLayoutRes;

        PageModel(@StringRes int titleRes, @LayoutRes int practiceLayoutRes) {
            this.titleRes = titleRes;
            this.practiceLayoutRes = practiceLayoutRes;
        }
    }
}
